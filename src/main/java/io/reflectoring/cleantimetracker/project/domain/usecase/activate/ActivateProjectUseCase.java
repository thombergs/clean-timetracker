package io.reflectoring.cleantimetracker.project.domain.usecase.activate;

import io.reflectoring.cleantimetracker.project.domain.entity.Project;
import io.reflectoring.cleantimetracker.project.domain.entity.ProjectId;
import io.reflectoring.cleantimetracker.project.domain.entity.ProjectStatus;
import io.reflectoring.cleantimetracker.project.domain.usecase.QueryProjectsPort;
import io.reflectoring.cleantimetracker.project.domain.usecase.SaveProjectPort;
import org.springframework.stereotype.Service;

@Service
public class ActivateProjectUseCase {

  private final SaveProjectPort saveProjectPort;

  private final QueryProjectsPort queryProjectsPort;

  public ActivateProjectUseCase(SaveProjectPort saveProjectPort,
                                QueryProjectsPort queryProjectsPort) {
    this.saveProjectPort = saveProjectPort;
    this.queryProjectsPort = queryProjectsPort;
  }

  public void activateProject(ProjectId projectId) {
    Project project = queryProjectsPort.findOne(projectId);
    project.setStatus(ProjectStatus.ACTIVE);
    saveProjectPort.saveProject(project);
  }

  public void deactivateProject(ProjectId projectId) {
    Project project = queryProjectsPort.findOne(projectId);
    project.setStatus(ProjectStatus.INACTIVE);
    saveProjectPort.saveProject(project);
  }
}
