package io.reflectoring.cleantimetracker.project.domain.port.driven.persistence;

import io.reflectoring.cleantimetracker.project.domain.entity.Project;

public interface CreateProjectPort {

  /**
   * Persists a new project.
   */
  Project createProject(Project project);

}
