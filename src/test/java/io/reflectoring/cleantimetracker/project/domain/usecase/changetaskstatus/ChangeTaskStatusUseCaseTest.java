package io.reflectoring.cleantimetracker.project.domain.usecase.changetaskstatus;

import java.util.Optional;

import io.reflectoring.cleantimetracker.MockitoExtension;
import io.reflectoring.cleantimetracker.project.domain.entity.Task;
import io.reflectoring.cleantimetracker.project.domain.entity.TaskStatus;
import io.reflectoring.cleantimetracker.project.domain.usecase.QueryTasksPort;
import io.reflectoring.cleantimetracker.project.domain.usecase.TaskNotFoundException;
import io.reflectoring.cleantimetracker.project.domain.usecase.TaskTestData;
import io.reflectoring.cleantimetracker.project.domain.usecase.UpdateTaskPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ChangeTaskStatusUseCaseTest {

  @InjectMocks
  private ChangeTaskStatusUseCase usecase;

  @Mock
  private QueryTasksPort queryTasksPort;

  @Mock
  private UpdateTaskPort updateTaskPort;

  @Test
  void whenTaskIsFound_activatesTask() {
    Task task = TaskTestData.defaultTask().get();
    when(queryTasksPort.findOne(task.getId())).thenReturn(Optional.of(task));
    usecase.activateTask(task.getId());
    verify(updateTaskPort, times(1)).changeStatus(eq(task), eq(TaskStatus.ACTIVE));
  }

  @Test
  void whenTaskIsNotFound_activateThrowsException() {
    Task task = TaskTestData.defaultTask().get();
    when(queryTasksPort.findOne(task.getId())).thenReturn(Optional.empty());
    assertThatThrownBy(() -> usecase.activateTask(task.getId())).isInstanceOf(TaskNotFoundException.class);
  }

  @Test
  void whenTaskIsFound_deactivatesTask() {
    Task task = TaskTestData.defaultTask().get();
    when(queryTasksPort.findOne(task.getId())).thenReturn(Optional.of(task));
    usecase.deactivateTask(task.getId());
    verify(updateTaskPort, times(1)).changeStatus(eq(task), eq(TaskStatus.INACTIVE));
  }

  @Test
  void whenTaskIsNotFound_deactivateThrowsException() {
    Task task = TaskTestData.defaultTask().get();
    when(queryTasksPort.findOne(task.getId())).thenReturn(Optional.empty());
    assertThatThrownBy(() -> usecase.deactivateTask(task.getId())).isInstanceOf(TaskNotFoundException.class);
  }

}