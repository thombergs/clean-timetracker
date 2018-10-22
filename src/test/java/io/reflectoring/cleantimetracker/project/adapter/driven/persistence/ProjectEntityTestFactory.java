package io.reflectoring.cleantimetracker.project.adapter.driven.persistence;

import org.springframework.stereotype.Component;

@Component
class ProjectEntityTestFactory {

  static final String SQL = "/io/reflectoring/cleantimetracker/project/adapter/persistence/default-project.sql";

  private ProjectRepository projectRepository;

  ProjectEntityTestFactory(ProjectRepository projectRepository) {
    this.projectRepository = projectRepository;
  }

  ProjectEntity defaultProject() {
    return projectRepository
            .findById(1L)
            .orElse(null);
  }

}
