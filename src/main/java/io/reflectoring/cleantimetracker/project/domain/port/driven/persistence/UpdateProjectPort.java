package io.reflectoring.cleantimetracker.project.domain.port.driven.persistence;

import io.reflectoring.cleantimetracker.project.domain.entity.Project;
import io.reflectoring.cleantimetracker.project.domain.entity.ProjectStatus;

public interface UpdateProjectPort {

  void changeStatus(Project project, ProjectStatus status);

}
