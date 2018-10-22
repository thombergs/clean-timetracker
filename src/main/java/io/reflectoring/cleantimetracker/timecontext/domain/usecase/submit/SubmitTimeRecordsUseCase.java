package io.reflectoring.cleantimetracker.timecontext.domain.usecase.submit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.reflectoring.cleantimetracker.timecontext.domain.entity.TimeRecord;
import io.reflectoring.cleantimetracker.timecontext.domain.entity.TimeRecordStatus;
import io.reflectoring.cleantimetracker.timecontext.domain.entity.TimeTrackingTask;
import io.reflectoring.cleantimetracker.timecontext.domain.port.out.persistence.SaveTimeRecordsPort;
import io.reflectoring.cleantimetracker.timecontext.domain.port.out.projectcontext.QueryTasksPort;
import org.springframework.stereotype.Service;
import static java.util.stream.Collectors.*;

@Service
public class SubmitTimeRecordsUseCase {

  private static final int MAXIMUM_MINUTES_PER_RECORD = 12 * 60;

  private static final int MAXIMUM_MINUTES_PER_DAY = 24 * 60;

  private SaveTimeRecordsPort saveTimeRecordsPort;

  private QueryTasksPort queryTasksPort;

  public SubmitTimeRecordsUseCase(SaveTimeRecordsPort saveTimeRecordsPort, QueryTasksPort queryTasksPort) {
    this.saveTimeRecordsPort = saveTimeRecordsPort;
    this.queryTasksPort = queryTasksPort;
  }

  public void submitTimeRecords(List<SubmitTimeRecordInputData> records) {
    records.forEach(this::rejectSingleRecordWhenTooManyMinutes);
    rejectRecordsWhenTooManyMinutesOnDay(records);
    rejectMultipleRecordsPerTaskAndDay(records);
    saveTimeRecordsPort.saveTimeRecords(toTimeRecords(records));
  }

  private List<TimeRecord> toTimeRecords(List<SubmitTimeRecordInputData> inputRecords) {
    List<TimeRecord> records = new ArrayList<>();
    for (SubmitTimeRecordInputData inputRecord : inputRecords) {
      records.add(TimeRecord.builder()
              .date(inputRecord.getDate())
              .minutes(inputRecord.getMinutes())
              .taskId(inputRecord.getTaskId())
              .status(TimeRecordStatus.OPEN)
              .build());
    }
    return records;
  }

  private Map<Long, TimeTrackingTask> tasksById(List<SubmitTimeRecordInputData> records) {
    Set<Long> taskIds = records.stream()
            .map(SubmitTimeRecordInputData::getTaskId)
            .collect(toSet());
    return queryTasksPort.listByIds(taskIds).stream()
            .collect(toMap(TimeTrackingTask::getId, (task) -> task));
  }

  private void rejectSingleRecordWhenTooManyMinutes(SubmitTimeRecordInputData record) {
    if (record.getMinutes() > MAXIMUM_MINUTES_PER_RECORD) {
      throw new TooMuchTimePerRecordException(record.getMinutes(), MAXIMUM_MINUTES_PER_RECORD);
    }
  }

  private void rejectRecordsWhenTooManyMinutesOnDay(List<SubmitTimeRecordInputData> records) {
    Map<LocalDate, Integer> minutesPerDay = records.stream()
            .collect(groupingBy(SubmitTimeRecordInputData::getDate, summingInt(SubmitTimeRecordInputData::getMinutes)));
    minutesPerDay.forEach((date, minutes) -> {
      if (minutes > MAXIMUM_MINUTES_PER_DAY) {
        throw new TooMuchTimePerDayException(minutes, date, MAXIMUM_MINUTES_PER_DAY);
      }
    });

    // TODO: this check should include records already stored out the database
  }

  private void rejectMultipleRecordsPerTaskAndDay(List<SubmitTimeRecordInputData> records) {
    Map<LocalDate, Map<Long, List<SubmitTimeRecordInputData>>> recordsPerDayAndTask = records.stream()
            .collect(groupingBy(SubmitTimeRecordInputData::getDate,
                    groupingBy(SubmitTimeRecordInputData::getTaskId)));
    recordsPerDayAndTask.forEach((date, map) -> {
      map.forEach((taskId, recordsList) -> {
        if (recordsList.size() > 1) {
          throw new TooManyRecordsPerDayException();
        }
      });
    });

    // TODO: this check should include records already stored out the database
  }

}
