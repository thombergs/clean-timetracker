package io.reflectoring.cleantimetracker.projectcontext.domain.port.out.persistence;

import io.reflectoring.cleantimetracker.projectcontext.domain.entity.Task;
import io.reflectoring.cleantimetracker.projectcontext.domain.entity.TaskStatus;

public interface UpdateTaskPort {

  void changeStatus(Task task, TaskStatus status);

}
