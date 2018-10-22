package io.reflectoring.cleantimetracker.projectcontext.domain.usecase.addtask;

import java.util.Optional;

import io.reflectoring.cleantimetracker.MockitoExtension;
import io.reflectoring.cleantimetracker.projectcontext.domain.entity.ProjectId;
import io.reflectoring.cleantimetracker.projectcontext.domain.entity.Task;
import io.reflectoring.cleantimetracker.projectcontext.domain.port.out.persistence.CreateTaskPort;
import io.reflectoring.cleantimetracker.projectcontext.domain.port.out.persistence.QueryProjectsPort;
import io.reflectoring.cleantimetracker.projectcontext.domain.usecase.ProjectNotFoundException;
import io.reflectoring.cleantimetracker.projectcontext.domain.usecase.ProjectTestFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AddTaskUseCaseTest {

  @Mock
  private QueryProjectsPort queryProjectsPort;

  @Mock
  private CreateTaskPort createTaskPort;

  @InjectMocks
  private AddTaskUseCase usecase;

  @Test
  void whenProjectNotFound_thenFails() {
    ProjectId projectId = ProjectId.of(42L);
    when(queryProjectsPort.findOne(projectId)).thenReturn(Optional.empty());
    assertThatThrownBy(() -> {
      usecase.addTask("My Task", true, projectId);
    }).isInstanceOf(ProjectNotFoundException.class);
  }

  @Test
  void whenProjectFound_thenCallsSaveTaskPort() {
    ProjectId projectId = ProjectId.of(42L);
    when(queryProjectsPort.findOne(projectId)).thenReturn(ProjectTestFactory.defaultProject());
    usecase.addTask("My Task", true, projectId);
    verify(createTaskPort, times(1)).saveTask(any(Task.class));
  }

}