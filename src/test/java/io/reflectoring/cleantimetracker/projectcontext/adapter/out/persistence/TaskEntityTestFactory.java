package io.reflectoring.cleantimetracker.projectcontext.adapter.out.persistence;

import org.springframework.stereotype.Component;

@Component
class TaskEntityTestFactory {

  static final String SQL = "/io/reflectoring/cleantimetracker/projectcontext/adapter/out/persistence/default-task.sql";

  private TaskEntityRepository taskRepository;

  TaskEntityTestFactory(TaskEntityRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  TaskEntity defaultTask() {
    return taskRepository.findById(1L)
            .orElse(null);
  }

}
