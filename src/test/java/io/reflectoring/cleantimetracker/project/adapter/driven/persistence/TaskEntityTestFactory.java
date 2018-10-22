package io.reflectoring.cleantimetracker.project.adapter.driven.persistence;

import org.springframework.stereotype.Component;

@Component
class TaskEntityTestFactory {

  static final String SQL = "/io/reflectoring/cleantimetracker/project/adapter/persistence/default-task.sql";

  private TaskEntityRepository taskRepository;

  TaskEntityTestFactory(TaskEntityRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  TaskEntity defaultTask() {
    return taskRepository.findById(1L)
            .orElse(null);
  }

}
