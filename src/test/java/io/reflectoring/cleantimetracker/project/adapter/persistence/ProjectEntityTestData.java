package io.reflectoring.cleantimetracker.project.adapter.persistence;

import org.springframework.stereotype.Component;

@Component
class ProjectEntityTestData {

  static final String SQL = "/io/reflectoring/cleantimetracker/project/adapter/persistence/default-project.sql";

  private ProjectRepository projectRepository;

  ProjectEntityTestData(ProjectRepository projectRepository) {
    this.projectRepository = projectRepository;
  }

  ProjectEntity defaultProject() {
    return projectRepository
            .findById(1L)
            .orElse(null);
  }

}
