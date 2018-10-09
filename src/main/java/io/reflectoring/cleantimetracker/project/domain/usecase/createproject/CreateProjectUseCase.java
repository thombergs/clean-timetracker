package io.reflectoring.cleantimetracker.project.domain.usecase.createproject;

import io.reflectoring.cleantimetracker.project.domain.entity.Project;
import org.springframework.stereotype.Service;

@Service
public class CreateProjectUseCase {

  private final CreateProjectPort createProjectPort;

  public CreateProjectUseCase(CreateProjectPort createProjectPort) {
    this.createProjectPort = createProjectPort;
  }

  public Project createProject(String name) {
    Project project = Project.builder()
            .name(name)
            .build();
    return this.createProjectPort.createProject(project);
  }

}
