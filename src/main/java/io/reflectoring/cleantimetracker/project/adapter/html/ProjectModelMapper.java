package io.reflectoring.cleantimetracker.project.adapter.html;

import java.util.List;
import java.util.stream.Collectors;

import io.reflectoring.cleantimetracker.project.domain.entity.Project;
import io.reflectoring.cleantimetracker.project.domain.entity.ProjectId;
import org.springframework.stereotype.Component;

@Component
public class ProjectModelMapper {

  public ProjectModel toModel(Project domainObject) {
    return ProjectModel.builder()
            .id(domainObject.getId().getValue())
            .name(domainObject.getName())
            .build();
  }

  public List<ProjectModel> toModels(List<Project> domainObjects) {
    return domainObjects.stream()
            .map(this::toModel)
            .collect(Collectors.toList());
  }

  public Project toDomainObject(ProjectModel model) {
    return Project.builder()
            .id(ProjectId.of(model.getId()))
            .name(model.getName())
            .build();
  }

  public List<Project> toDomainObjects(List<ProjectModel> models) {
    return models.stream()
            .map(this::toDomainObject)
            .collect(Collectors.toList());
  }

}
