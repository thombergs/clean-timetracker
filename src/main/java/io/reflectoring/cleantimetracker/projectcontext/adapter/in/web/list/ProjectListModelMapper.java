package io.reflectoring.cleantimetracker.projectcontext.adapter.in.web.list;

import java.util.List;
import java.util.stream.Collectors;

import io.reflectoring.cleantimetracker.projectcontext.domain.entity.Project;
import org.springframework.stereotype.Component;

@Component
class ProjectListModelMapper {

  ProjectListModel toModel(Project domainObject) {
    return ProjectListModel.builder()
            .id(domainObject.getId().getValue())
            .name(domainObject.getName())
            .status(domainObject.getStatus())
            .build();
  }

  List<ProjectListModel> toModels(List<Project> domainObjects) {
    return domainObjects.stream()
            .map(this::toModel)
            .collect(Collectors.toList());
  }

}
