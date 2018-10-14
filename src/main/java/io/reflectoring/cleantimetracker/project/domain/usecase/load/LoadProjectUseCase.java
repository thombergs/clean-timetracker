package io.reflectoring.cleantimetracker.project.domain.usecase.load;

import io.reflectoring.cleantimetracker.project.domain.entity.Project;
import io.reflectoring.cleantimetracker.project.domain.entity.ProjectId;
import io.reflectoring.cleantimetracker.project.domain.usecase.ProjectNotFoundException;
import io.reflectoring.cleantimetracker.project.domain.usecase.QueryProjectsPort;
import org.springframework.stereotype.Service;

@Service
public class LoadProjectUseCase {

  private QueryProjectsPort queryPort;

  public LoadProjectUseCase(QueryProjectsPort queryPort) {
    this.queryPort = queryPort;
  }

  public Project loadProject(ProjectId projectId) {
    Project project = queryPort.findOne(projectId);
    if (project == null) {
      throw new ProjectNotFoundException(projectId);
    }
    return project;
  }

}
