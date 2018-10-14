package io.reflectoring.cleantimetracker.project.domain.usecase;

import io.reflectoring.cleantimetracker.project.domain.entity.Task;

public interface CreateTaskPort {

  Task saveTask(Task task);

}
