package io.reflectoring.cleantimetracker.project.domain.usecase;

import io.reflectoring.cleantimetracker.project.domain.entity.Project;
import io.reflectoring.cleantimetracker.project.domain.entity.ProjectStatus;

public interface UpdateProjectPort {

  void changeStatus(Project project, ProjectStatus status);

}
