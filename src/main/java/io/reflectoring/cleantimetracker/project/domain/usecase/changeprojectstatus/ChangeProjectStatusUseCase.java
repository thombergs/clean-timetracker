package io.reflectoring.cleantimetracker.project.domain.usecase.changeprojectstatus;

import javax.transaction.Transactional;

import java.util.Optional;

import io.reflectoring.cleantimetracker.project.domain.entity.Project;
import io.reflectoring.cleantimetracker.project.domain.entity.ProjectId;
import io.reflectoring.cleantimetracker.project.domain.entity.ProjectStatus;
import io.reflectoring.cleantimetracker.project.domain.port.driven.persistence.QueryProjectsPort;
import io.reflectoring.cleantimetracker.project.domain.port.driven.persistence.UpdateProjectPort;
import io.reflectoring.cleantimetracker.project.domain.usecase.ProjectNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ChangeProjectStatusUseCase {

  private final UpdateProjectPort updateProjectPort;

  private final QueryProjectsPort queryProjectsPort;

  public ChangeProjectStatusUseCase(UpdateProjectPort updateProjectPort,
                                    QueryProjectsPort queryProjectsPort) {
    this.updateProjectPort = updateProjectPort;
    this.queryProjectsPort = queryProjectsPort;
  }

  public void activateProject(ProjectId projectId) {
    Optional<Project> optionalProject = queryProjectsPort.findOne(projectId);
    if (optionalProject.isPresent()) {
      updateProjectPort.changeStatus(optionalProject.get(), ProjectStatus.ACTIVE);
    } else {
      throw new ProjectNotFoundException(projectId);
    }
  }

  public void deactivateProject(ProjectId projectId) {
    Optional<Project> optionalProject = queryProjectsPort.findOne(projectId);
    if (optionalProject.isPresent()) {
      updateProjectPort.changeStatus(optionalProject.get(), ProjectStatus.INACTIVE);
    } else {
      throw new ProjectNotFoundException(projectId);
    }
  }
}
