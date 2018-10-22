package io.reflectoring.cleantimetracker.project.domain.port.driven.persistence;

import io.reflectoring.cleantimetracker.project.domain.entity.Task;
import io.reflectoring.cleantimetracker.project.domain.entity.TaskStatus;

public interface UpdateTaskPort {

  void changeStatus(Task task, TaskStatus status);

}
