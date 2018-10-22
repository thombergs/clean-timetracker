package io.reflectoring.cleantimetracker.project.domain.usecase.loadproject;

import java.util.Optional;

import io.reflectoring.cleantimetracker.project.domain.entity.Project;
import io.reflectoring.cleantimetracker.project.domain.entity.ProjectId;
import io.reflectoring.cleantimetracker.project.domain.port.driven.persistence.QueryProjectsPort;
import io.reflectoring.cleantimetracker.project.domain.usecase.ProjectNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoadProjectUseCase {

  private QueryProjectsPort queryPort;

  public LoadProjectUseCase(QueryProjectsPort queryPort) {
    this.queryPort = queryPort;
  }

  public Project loadProject(ProjectId projectId) {
    Optional<Project> optionalProject = queryPort.findOne(projectId);
    if (optionalProject.isPresent()) {
      return optionalProject.get();
    } else {
      throw new ProjectNotFoundException(projectId);
    }
  }

}
