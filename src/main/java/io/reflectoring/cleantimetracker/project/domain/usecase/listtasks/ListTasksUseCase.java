package io.reflectoring.cleantimetracker.project.domain.usecase.listtasks;

import java.util.List;

import io.reflectoring.cleantimetracker.project.domain.entity.ProjectId;
import io.reflectoring.cleantimetracker.project.domain.entity.Task;
import io.reflectoring.cleantimetracker.project.domain.port.driven.persistence.QueryTasksPort;
import org.springframework.stereotype.Service;

@Service
public class ListTasksUseCase {

  private QueryTasksPort queryTasksPort;

  public ListTasksUseCase(QueryTasksPort queryTasksPort) {
    this.queryTasksPort = queryTasksPort;
  }

  public List<Task> listTasksForProject(ProjectId projectId) {
    return queryTasksPort.listTasksForProject(projectId);
  }

}
