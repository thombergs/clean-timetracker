package io.reflectoring.cleantimetracker.project.domain.usecase;

import java.util.Optional;

import io.reflectoring.cleantimetracker.project.domain.entity.Task;
import io.reflectoring.cleantimetracker.project.domain.entity.TaskId;
import io.reflectoring.cleantimetracker.project.domain.entity.TaskStatus;

public class TaskTestData {

  public static Optional<Task> defaultTask() {
    return Optional.of(Task.builder()
            .name("Task 1")
            .id(TaskId.of(1L))
            .project(ProjectTestData.defaultProject().get())
            .invoiceable(Boolean.TRUE)
            .status(TaskStatus.ACTIVE)
            .build());

  }

}
