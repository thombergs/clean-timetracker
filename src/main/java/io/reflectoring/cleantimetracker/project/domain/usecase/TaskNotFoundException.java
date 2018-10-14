package io.reflectoring.cleantimetracker.project.domain.usecase;

import io.reflectoring.cleantimetracker.project.domain.entity.TaskId;

public class TaskNotFoundException extends RuntimeException {

  public TaskNotFoundException(TaskId taskId) {
    super(String.format("Task with ID %d not found!", taskId.getValue()));
  }

}
