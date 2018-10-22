package io.reflectoring.cleantimetracker.project.domain.port.driven.persistence;

import io.reflectoring.cleantimetracker.project.domain.entity.Task;

public interface CreateTaskPort {

  Task saveTask(Task task);

}
