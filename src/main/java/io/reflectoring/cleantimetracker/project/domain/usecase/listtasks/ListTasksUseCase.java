package io.reflectoring.cleantimetracker.project.domain.usecase.listtasks;

import java.util.List;

import io.reflectoring.cleantimetracker.project.domain.entity.ProjectId;
import io.reflectoring.cleantimetracker.project.domain.entity.Task;
import io.reflectoring.cleantimetracker.project.domain.usecase.ListTasksPort;
import org.springframework.stereotype.Service;

@Service
public class ListTasksUseCase {

  private ListTasksPort listTasksPort;

  public ListTasksUseCase(ListTasksPort listTasksPort) {
    this.listTasksPort = listTasksPort;
  }

  public List<Task> listTasksForProject(ProjectId projectId) {
    return listTasksPort.listTasksForProject(projectId);
  }

}
