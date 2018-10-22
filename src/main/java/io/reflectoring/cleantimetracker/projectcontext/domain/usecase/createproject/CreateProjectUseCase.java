package io.reflectoring.cleantimetracker.projectcontext.domain.usecase.createproject;

import javax.transaction.Transactional;

import io.reflectoring.cleantimetracker.projectcontext.domain.entity.Project;
import io.reflectoring.cleantimetracker.projectcontext.domain.entity.ProjectStatus;
import io.reflectoring.cleantimetracker.projectcontext.domain.port.out.persistence.CreateProjectPort;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CreateProjectUseCase {

  private final CreateProjectPort createProjectPort;

  public CreateProjectUseCase(CreateProjectPort createProjectPort) {
    this.createProjectPort = createProjectPort;
  }

  public Project createProject(String name) {
    Project project = Project.builder()
            .name(name)
            .status(ProjectStatus.INACTIVE)
            .build();
    return this.createProjectPort.createProject(project);
  }

}
