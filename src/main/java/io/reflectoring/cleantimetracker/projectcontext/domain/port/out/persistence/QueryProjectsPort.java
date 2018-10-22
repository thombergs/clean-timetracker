package io.reflectoring.cleantimetracker.projectcontext.domain.port.out.persistence;

import java.util.List;
import java.util.Optional;

import io.reflectoring.cleantimetracker.projectcontext.domain.entity.Project;
import io.reflectoring.cleantimetracker.projectcontext.domain.entity.ProjectId;

public interface QueryProjectsPort {

  List<Project> listProjects();

  Optional<Project> findOne(ProjectId projectId);

}
