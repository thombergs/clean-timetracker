package io.reflectoring.cleantimetracker.time.domain.usecase.list;

import java.time.LocalDate;
import java.util.List;

import io.reflectoring.cleantimetracker.MockitoExtension;
import io.reflectoring.cleantimetracker.time.domain.entity.TimeRecord;
import io.reflectoring.cleantimetracker.time.domain.entity.TimeRecordTestFactory;
import io.reflectoring.cleantimetracker.time.domain.entity.TimeRecordWithTask;
import io.reflectoring.cleantimetracker.time.domain.entity.TimeTrackingTask;
import io.reflectoring.cleantimetracker.time.domain.entity.TimeTrackingTaskTestFactory;
import io.reflectoring.cleantimetracker.time.domain.port.QueryTasksPort;
import io.reflectoring.cleantimetracker.time.domain.port.QueryTimeRecordsPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ListTimeRecordsUseCaseTest {

  @InjectMocks
  private ListTimeRecordsUseCase usecase;

  @Mock
  private QueryTimeRecordsPort queryTimeRecordsPort;

  @Mock
  private QueryTasksPort queryTasksPort;

  @Test
  void whenIntervalMoreThanAMonth_thenThrowsException() {
    ListTimeRecordsQueryParameters params = ListTimeRecordsQueryParameters.builder()
            .start(LocalDate.of(2018, 10, 1))
            .end(LocalDate.of(2018, 11, 15))
            .build();
    assertThatThrownBy(() -> usecase.listTimeRecords(params)).isInstanceOf(IntervalTooLongException.class);
  }

  @Test
  void whenEndBeforeStart_thenThrowsException() {
    ListTimeRecordsQueryParameters params = ListTimeRecordsQueryParameters.builder()
            .start(LocalDate.of(2018, 10, 1))
            .end(LocalDate.of(2018, 9, 30))
            .build();
    assertThatThrownBy(() -> usecase.listTimeRecords(params)).isInstanceOf(IntervalEndBeforeStartException.class);
  }

  @Test
  void whenInputValid_thenProvidesTimeRecordsWithTask() {
    LocalDate start = LocalDate.of(2018, 10, 1);
    LocalDate end = LocalDate.of(2018, 10, 5);
    Long[] taskIds = new Long[]{1L, 2L, 3L};

    ListTimeRecordsQueryParameters params = ListTimeRecordsQueryParameters.builder()
            .start(start)
            .end(end)
            .build();

    List<TimeRecord> providedRecords = whenPersistenceProvidesTimeRecords(start, end, taskIds);
    List<TimeTrackingTask> providedTasks = whenProjectContextProvidesTasks(taskIds);

    List<TimeRecordWithTask> records = usecase.listTimeRecords(params);
    assertThat(records).hasSize(providedRecords.size());

    records.forEach((record) -> assertThat(record.getTask()).isNotNull());

  }

  private List<TimeRecord> whenPersistenceProvidesTimeRecords(LocalDate start, LocalDate end, Long... taskIds) {
    List<TimeRecord> records = TimeRecordTestFactory.defaultRecords(taskIds);
    when(queryTimeRecordsPort.listTimeRecords(eq(start), eq(end))).thenReturn(records);
    return records;
  }

  private List<TimeTrackingTask> whenProjectContextProvidesTasks(Long... taskIds) {
    List<TimeTrackingTask> tasks = TimeTrackingTaskTestFactory.defaultTasks(taskIds);
    when(queryTasksPort.listByIds(anySet())).thenReturn(tasks);
    return tasks;
  }

}