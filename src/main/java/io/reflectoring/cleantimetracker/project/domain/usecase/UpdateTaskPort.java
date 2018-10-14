package io.reflectoring.cleantimetracker.project.domain.usecase;

import io.reflectoring.cleantimetracker.project.domain.entity.Task;
import io.reflectoring.cleantimetracker.project.domain.entity.TaskStatus;

public interface UpdateTaskPort {

  void changeStatus(Task task, TaskStatus status);

}
