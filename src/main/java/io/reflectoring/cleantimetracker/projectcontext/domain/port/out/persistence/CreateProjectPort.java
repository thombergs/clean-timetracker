package io.reflectoring.cleantimetracker.projectcontext.domain.port.out.persistence;

import io.reflectoring.cleantimetracker.projectcontext.domain.entity.Project;

public interface CreateProjectPort {

  /**
   * Persists a new project.
   */
  Project createProject(Project project);

}
