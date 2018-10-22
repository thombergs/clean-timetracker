package io.reflectoring.cleantimetracker.time.domain.usecase.list;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import io.reflectoring.cleantimetracker.time.domain.entity.TimeRecord;
import io.reflectoring.cleantimetracker.time.domain.entity.TimeRecordWithTask;
import io.reflectoring.cleantimetracker.time.domain.entity.TimeTrackingTask;
import io.reflectoring.cleantimetracker.time.domain.port.QueryTasksPort;
import io.reflectoring.cleantimetracker.time.domain.port.QueryTimeRecordsPort;
import org.springframework.stereotype.Service;

@Service
public class ListTimeRecordsUseCase {

  private static final int INTERVAL_MAXIMUM_DAYS = 31;

  private QueryTimeRecordsPort queryTimeRecordsPort;

  private QueryTasksPort queryTasksPort;

  public ListTimeRecordsUseCase(QueryTimeRecordsPort queryTimeRecordsPort, QueryTasksPort queryTasksPort) {
    this.queryTimeRecordsPort = queryTimeRecordsPort;
    this.queryTasksPort = queryTasksPort;
  }

  public List<TimeRecordWithTask> listTimeRecords(ListTimeRecordsQueryParameters queryParams) {
    rejectIfEndBeforeStart(queryParams);
    rejectIfIntervalIsTooLong(queryParams);
    List<TimeRecord> timeRecords = queryTimeRecordsPort.listTimeRecords(queryParams.getStart(), queryParams.getEnd());
    return expandTasks(timeRecords);
  }

  public List<TimeTrackingTask> listAllTasks() {
    return queryTasksPort.listAllTasks();
  }

  /**
   * Expands the task ID in a set of {@link TimeRecord}s to the real Task data. This is necessary since
   * the Task data is loaded from another bounded context.
   */
  private List<TimeRecordWithTask> expandTasks(List<TimeRecord> timeRecords) {
    Set<Long> taskIds = timeRecords.stream()
            .map(TimeRecord::getTaskId)
            .collect(Collectors.toSet());

    Map<Long, TimeTrackingTask> tasksById = queryTasksPort.listByIds(taskIds).stream()
            .collect(Collectors.toMap(TimeTrackingTask::getId, (task) -> task));

    List<TimeRecordWithTask> expandedTimeRecords = new ArrayList<>();
    timeRecords.forEach((record) -> expandedTimeRecords.add(TimeRecordWithTask.fromTimeRecord(record, tasksById.get(record.getTaskId()))));

    return expandedTimeRecords;
  }

  private void rejectIfEndBeforeStart(ListTimeRecordsQueryParameters queryParameters) {
    if (queryParameters.getStart().isAfter(queryParameters.getEnd())) {
      throw new IntervalEndBeforeStartException(queryParameters.getStart(), queryParameters.getEnd());
    }
  }

  private void rejectIfIntervalIsTooLong(ListTimeRecordsQueryParameters queryParameters) {
    LocalDate latestAllowedEnd = queryParameters.getStart().plusDays(INTERVAL_MAXIMUM_DAYS);
    if (queryParameters.getEnd().isAfter(latestAllowedEnd)) {
      throw new IntervalTooLongException(queryParameters.getStart(), queryParameters.getEnd(), INTERVAL_MAXIMUM_DAYS);
    }
  }

}
