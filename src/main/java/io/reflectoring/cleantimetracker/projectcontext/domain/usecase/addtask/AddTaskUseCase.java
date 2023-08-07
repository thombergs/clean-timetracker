package io.reflectoring.cleantimetracker.projectcontext.domain.usecase.addtask;

import jakarta.transaction.Transactional;

import java.util.Optional;

import io.reflectoring.cleantimetracker.projectcontext.domain.entity.Project;
import io.reflectoring.cleantimetracker.projectcontext.domain.entity.ProjectId;
import io.reflectoring.cleantimetracker.projectcontext.domain.entity.Task;
import io.reflectoring.cleantimetracker.projectcontext.domain.port.out.persistence.CreateTaskPort;
import io.reflectoring.cleantimetracker.projectcontext.domain.port.out.persistence.QueryProjectsPort;
import io.reflectoring.cleantimetracker.projectcontext.domain.usecase.ProjectNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AddTaskUseCase {

  private QueryProjectsPort queryProjectsPort;

  private CreateTaskPort createTaskPort;

  public AddTaskUseCase(QueryProjectsPort queryProjectsPort, CreateTaskPort createTaskPort) {
    this.queryProjectsPort = queryProjectsPort;
    this.createTaskPort = createTaskPort;
  }

  public void addTask(String taskName, boolean invoiceable, ProjectId projectId) {
    Project project = findProjectOrFail(projectId);

    Task task = Task.builder()
            .invoiceable(invoiceable)
            .name(taskName)
            .project(project)
            .build();

    createTaskPort.saveTask(task);
  }

  private Project findProjectOrFail(ProjectId projectId) {
    Optional<Project> project = queryProjectsPort.findOne(projectId);
    return project.orElseThrow(() -> new ProjectNotFoundException(projectId));
  }

}
