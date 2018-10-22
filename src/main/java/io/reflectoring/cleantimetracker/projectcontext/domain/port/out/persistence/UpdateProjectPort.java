package io.reflectoring.cleantimetracker.projectcontext.domain.port.out.persistence;

import io.reflectoring.cleantimetracker.projectcontext.domain.entity.Project;
import io.reflectoring.cleantimetracker.projectcontext.domain.entity.ProjectStatus;

public interface UpdateProjectPort {

  void changeStatus(Project project, ProjectStatus status);

}
