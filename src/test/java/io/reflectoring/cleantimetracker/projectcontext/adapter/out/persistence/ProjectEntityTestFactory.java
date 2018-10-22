package io.reflectoring.cleantimetracker.projectcontext.adapter.out.persistence;

import org.springframework.stereotype.Component;

@Component
class ProjectEntityTestFactory {

  static final String SQL = "/io/reflectoring/cleantimetracker/projectcontext/adapter/out/persistence/default-project.sql";

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
