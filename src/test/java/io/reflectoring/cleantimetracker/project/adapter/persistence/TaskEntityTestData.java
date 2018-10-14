package io.reflectoring.cleantimetracker.project.adapter.persistence;

import org.springframework.stereotype.Component;

@Component
class TaskEntityTestData {

  static final String SQL = "/io/reflectoring/cleantimetracker/project/adapter/persistence/default-task.sql";

  private TaskEntityRepository taskRepository;

  TaskEntityTestData(TaskEntityRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  TaskEntity defaultTask() {
    return taskRepository.findById(1L)
            .orElse(null);
  }

}
