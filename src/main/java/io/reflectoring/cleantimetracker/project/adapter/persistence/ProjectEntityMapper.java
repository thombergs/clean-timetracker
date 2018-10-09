package io.reflectoring.cleantimetracker.project.adapter.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import io.reflectoring.cleantimetracker.project.domain.entity.Project;
import io.reflectoring.cleantimetracker.project.domain.entity.ProjectId;
import org.springframework.stereotype.Component;

@Component
public class ProjectEntityMapper {

  public ProjectEntity toEntity(Project domainObject) {
    return ProjectEntity.builder()
            .id(domainObject.getId() != null ? domainObject.getId().getValue() : null)
            .name(domainObject.getName())
            .build();
  }

  public List<ProjectEntity> toEntities(List<Project> domainObjects) {
    return domainObjects.stream()
            .map(this::toEntity)
            .collect(Collectors.toList());
  }

  public Project toDomainObject(ProjectEntity entity) {
    return Project.builder()
            .id(ProjectId.of(entity.getId()))
            .name(entity.getName())
            .build();
  }

  public List<Project> toDomainObjects(Iterable<ProjectEntity> entities) {
    List<Project> projects = new ArrayList<>();
    entities.forEach(entity -> projects.add(toDomainObject(entity)));
    return projects;
  }

}
