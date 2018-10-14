package io.reflectoring.cleantimetracker.project.domain.usecase;

import io.reflectoring.cleantimetracker.project.domain.entity.ProjectId;

public class ProjectNotFoundException extends RuntimeException {

  public ProjectNotFoundException(ProjectId projectId) {
    super(String.format("Project with ID %d not found!", projectId.getValue()));
  }

}
