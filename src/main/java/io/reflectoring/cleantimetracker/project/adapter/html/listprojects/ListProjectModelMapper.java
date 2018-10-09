package io.reflectoring.cleantimetracker.project.adapter.html.listprojects;

import java.util.List;
import java.util.stream.Collectors;

import io.reflectoring.cleantimetracker.project.domain.entity.Project;
import org.springframework.stereotype.Component;

@Component
class ListProjectModelMapper {

  ListProjectModel toModel(Project domainObject) {
    return ListProjectModel.builder()
            .id(domainObject.getId().getValue())
            .name(domainObject.getName())
            .status(domainObject.getStatus())
            .build();
  }

  List<ListProjectModel> toModels(List<Project> domainObjects) {
    return domainObjects.stream()
            .map(this::toModel)
            .collect(Collectors.toList());
  }

}
