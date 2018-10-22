package io.reflectoring.cleantimetracker.time.domain.usecase.submit;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import io.reflectoring.cleantimetracker.MockitoExtension;
import io.reflectoring.cleantimetracker.timecontext.domain.entity.TimeRecord;
import io.reflectoring.cleantimetracker.timecontext.domain.entity.TimeTrackingTask;
import io.reflectoring.cleantimetracker.timecontext.domain.port.out.persistence.SaveTimeRecordsPort;
import io.reflectoring.cleantimetracker.timecontext.domain.port.out.projectcontext.QueryTasksPort;
import io.reflectoring.cleantimetracker.timecontext.domain.usecase.submit.SubmitTimeRecordInputData;
import io.reflectoring.cleantimetracker.timecontext.domain.usecase.submit.SubmitTimeRecordsUseCase;
import io.reflectoring.cleantimetracker.timecontext.domain.usecase.submit.TooManyRecordsPerDayException;
import io.reflectoring.cleantimetracker.timecontext.domain.usecase.submit.TooMuchTimePerDayException;
import io.reflectoring.cleantimetracker.timecontext.domain.usecase.submit.TooMuchTimePerRecordException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static io.reflectoring.cleantimetracker.time.domain.entity.TimeTrackingTaskTestFactory.*;
import static io.reflectoring.cleantimetracker.time.domain.usecase.submit.SubmitTimeRecordInputDataTestFactory.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SubmitTimeRecordsUseCaseTest {

  @InjectMocks
  private SubmitTimeRecordsUseCase usecase;

  @Mock
  private SaveTimeRecordsPort saveTimeRecordsPort;

  @Mock
  private QueryTasksPort queryTasksPort;

  @Test
  void whenTooManyMinutesOnSingleRecord_thenThrowsException() {
    Long taskId = 42L;
    List<SubmitTimeRecordInputData> records =
            Collections.singletonList(thirteenHours(taskId));
    whenTasksExist(taskId);
    assertThatThrownBy(() -> usecase.submitTimeRecords(records)).isInstanceOf(TooMuchTimePerRecordException.class);
  }

  @Test
  void whenTooManyMinutesPerDayInSubmittedData_thenThrowsException() {
    List<SubmitTimeRecordInputData> records =
            Arrays.asList(eightHours(1L), eightHours(2L), eightHours(3L), eightHours(4L));
    whenTasksExist(1L, 2L, 3L, 4L);
    assertThatThrownBy(() -> usecase.submitTimeRecords(records)).isInstanceOf(TooMuchTimePerDayException.class);
  }

  @Test
  void whenTooManyRecordsPerDayAndTaskInSubmittedData_thenThrowsException() {
    List<SubmitTimeRecordInputData> records =
            Arrays.asList(eightHours(1L), eightHours(1L), eightHours());
    whenTasksExist(1L);
    assertThatThrownBy(() -> usecase.submitTimeRecords(records)).isInstanceOf(TooManyRecordsPerDayException.class);
  }

  @Test
  @SuppressWarnings("unchecked")
  void whenInputValid_thenSavesRecords() {
    List<SubmitTimeRecordInputData> records =
            Arrays.asList(eightHours(1L), eightHours(2L));
    List<TimeTrackingTask> tasks = whenTasksExist(1L, 2L);

    usecase.submitTimeRecords(records);

    ArgumentCaptor<List<TimeRecord>> savedRecordsCaptor = ArgumentCaptor.forClass(List.class);
    verify(saveTimeRecordsPort).saveTimeRecords(savedRecordsCaptor.capture());

    List<TimeRecord> savedRecords = savedRecordsCaptor.getValue();
    assertThat(savedRecords).hasSize(records.size());
  }

  private List<TimeTrackingTask> whenTasksExist(Long... taskIds) {
    List<TimeTrackingTask> tasks = defaultTasks(taskIds);
    when(queryTasksPort.listByIds(new HashSet<>(Arrays.asList(taskIds)))).thenReturn(tasks);
    return tasks;
  }

}