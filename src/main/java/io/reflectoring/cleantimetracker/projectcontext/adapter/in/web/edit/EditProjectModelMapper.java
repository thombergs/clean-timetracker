package io.reflectoring.cleantimetracker.projectcontext.adapter.in.web.edit;

import java.util.List;

import io.reflectoring.cleantimetracker.projectcontext.domain.entity.Project;
import io.reflectoring.cleantimetracker.projectcontext.domain.entity.Task;
import org.springframework.stereotype.Component;

@Component
class EditProjectModelMapper {

  private TaskModelMapper taskModelMapper;

  EditProjectModelMapper(TaskModelMapper taskModelMapper) {
    this.taskModelMapper = taskModelMapper;
  }

  EditProjectModel toModel(Project domainObject, List<Task> tasks) {
    return EditProjectModel.builder()
            .id(domainObject.getId().getValue())
            .name(domainObject.getName())
            .status(domainObject.getStatus())
            .tasks(taskModelMapper.toModels(tasks))
            .build();
  }

}
