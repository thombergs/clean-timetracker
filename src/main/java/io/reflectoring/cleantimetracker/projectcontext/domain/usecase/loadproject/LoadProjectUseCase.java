package io.reflectoring.cleantimetracker.projectcontext.domain.usecase.loadproject;

import java.util.Optional;

import io.reflectoring.cleantimetracker.projectcontext.domain.entity.Project;
import io.reflectoring.cleantimetracker.projectcontext.domain.entity.ProjectId;
import io.reflectoring.cleantimetracker.projectcontext.domain.port.out.persistence.QueryProjectsPort;
import io.reflectoring.cleantimetracker.projectcontext.domain.usecase.ProjectNotFoundException;
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
