package io.reflectoring.cleantimetracker.project.domain.usecase;

import io.reflectoring.cleantimetracker.project.domain.entity.Project;
import io.reflectoring.cleantimetracker.project.domain.entity.ProjectId;
import io.reflectoring.cleantimetracker.project.domain.entity.ProjectStatus;

public class ProjectTestData {

  public static Project defaultProject() {
    return Project.builder()
            .id(ProjectId.of(1L))
            .status(ProjectStatus.ACTIVE)
            .name("Project 1")
            .build();
  }

}
