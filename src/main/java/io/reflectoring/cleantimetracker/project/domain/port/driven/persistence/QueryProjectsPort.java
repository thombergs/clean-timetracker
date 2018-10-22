package io.reflectoring.cleantimetracker.project.domain.port.driven.persistence;

import java.util.List;
import java.util.Optional;

import io.reflectoring.cleantimetracker.project.domain.entity.Project;
import io.reflectoring.cleantimetracker.project.domain.entity.ProjectId;

public interface QueryProjectsPort {

  List<Project> listProjects();

  Optional<Project> findOne(ProjectId projectId);

}
