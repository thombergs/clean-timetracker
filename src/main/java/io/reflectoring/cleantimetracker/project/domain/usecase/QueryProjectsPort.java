package io.reflectoring.cleantimetracker.project.domain.usecase;

import java.util.List;

import io.reflectoring.cleantimetracker.project.domain.entity.Project;
import io.reflectoring.cleantimetracker.project.domain.entity.ProjectId;

public interface QueryProjectsPort {

  List<Project> listProjects();

  Project findOne(ProjectId projectId);

}
