package io.reflectoring.cleantimetracker.project.domain.usecase.listprojects;

import java.util.List;

import io.reflectoring.cleantimetracker.project.domain.entity.Project;
import org.springframework.stereotype.Service;

@Service
public class ListProjectsUseCase {

  private ListProjectsPort listProjectsPort;

  public ListProjectsUseCase(ListProjectsPort listProjectsPort) {
    this.listProjectsPort = listProjectsPort;
  }

  public List<Project> listProjects() {
    return listProjectsPort.listProjects();
  }

}
