package io.reflectoring.cleantimetracker.projectcontext.domain.usecase.listtasks;

import java.util.List;

import io.reflectoring.cleantimetracker.projectcontext.domain.entity.ProjectId;
import io.reflectoring.cleantimetracker.projectcontext.domain.entity.Task;
import io.reflectoring.cleantimetracker.projectcontext.domain.port.out.persistence.QueryTasksPort;
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
