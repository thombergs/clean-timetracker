package io.reflectoring.cleantimetracker.project.domain.usecase.listprojects;

import java.util.List;

import io.reflectoring.cleantimetracker.project.domain.entity.Project;
import io.reflectoring.cleantimetracker.project.domain.usecase.QueryProjectsPort;
import org.springframework.stereotype.Service;

@Service
public class ListProjectsUseCase {

  private QueryProjectsPort queryPort;

  public ListProjectsUseCase(QueryProjectsPort queryPort) {
    this.queryPort = queryPort;
  }

  public List<Project> listProjects() {
    return queryPort.listProjects();
  }

}
