package io.reflectoring.cleantimetracker.project.adapter.html.listprojects;

import java.util.List;
import java.util.stream.Collectors;

import io.reflectoring.cleantimetracker.project.domain.entity.Project;
import io.reflectoring.cleantimetracker.project.domain.entity.ProjectId;
import org.springframework.stereotype.Component;

@Component
class ListProjectModelMapper {

  ListProjectModel toModel(Project domainObject) {
    return ListProjectModel.builder()
            .id(domainObject.getId().getValue())
            .name(domainObject.getName())
            .build();
  }

  List<ListProjectModel> toModels(List<Project> domainObjects) {
    return domainObjects.stream()
            .map(this::toModel)
            .collect(Collectors.toList());
  }

  Project toDomainObject(ListProjectModel model) {
    return Project.builder()
            .id(ProjectId.of(model.getId()))
            .name(model.getName())
            .build();
  }

  List<Project> toDomainObjects(List<ListProjectModel> models) {
    return models.stream()
            .map(this::toDomainObject)
            .collect(Collectors.toList());
  }

}
