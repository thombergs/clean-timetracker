package io.reflectoring.cleantimetracker.project.domain.usecase.addtask;

import java.util.Optional;

import io.reflectoring.cleantimetracker.project.domain.entity.Project;
import io.reflectoring.cleantimetracker.project.domain.entity.ProjectId;
import io.reflectoring.cleantimetracker.project.domain.entity.Task;
import io.reflectoring.cleantimetracker.project.domain.usecase.ProjectNotFoundException;
import io.reflectoring.cleantimetracker.project.domain.usecase.QueryProjectsPort;
import io.reflectoring.cleantimetracker.project.domain.usecase.SaveTaskPort;
import org.springframework.stereotype.Service;

@Service
public class AddTaskUseCase {

  private QueryProjectsPort queryProjectsPort;

  private SaveTaskPort saveTaskPort;

  public AddTaskUseCase(QueryProjectsPort queryProjectsPort, SaveTaskPort saveTaskPort) {
    this.queryProjectsPort = queryProjectsPort;
    this.saveTaskPort = saveTaskPort;
  }

  public void addTask(String taskName, boolean invoiceable, ProjectId projectId) {
    Project project = findProjectOrFail(projectId);

    Task task = Task.builder()
            .invoiceable(invoiceable)
            .name(taskName)
            .project(project)
            .build();

    saveTaskPort.saveTask(task);
  }

  private Project findProjectOrFail(ProjectId projectId) {
    Optional<Project> project = queryProjectsPort.findOne(projectId);
    return project.orElseThrow(() -> new ProjectNotFoundException(projectId));
  }

}
