package io.reflectoring.cleantimetracker.projectcontext.domain.port.out.persistence;

import io.reflectoring.cleantimetracker.projectcontext.domain.entity.Task;

public interface CreateTaskPort {

  Task saveTask(Task task);

}
