package io.reflectoring.cleantimetracker.project.domain.usecase.listprojects;

import java.util.List;

import io.reflectoring.cleantimetracker.project.domain.entity.Project;

public interface ListProjectsPort {

  List<Project> listProjects();

}
