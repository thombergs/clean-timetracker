package io.reflectoring.cleantimetracker.project.domain.usecase;

import io.reflectoring.cleantimetracker.project.domain.entity.Project;

public interface SaveProjectPort {

  /**
   * Updates the current state of the given project.
   */
  Project saveProject(Project project);

}
