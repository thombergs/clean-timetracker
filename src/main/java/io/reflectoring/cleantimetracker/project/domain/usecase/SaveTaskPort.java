package io.reflectoring.cleantimetracker.project.domain.usecase;

import io.reflectoring.cleantimetracker.project.domain.entity.Task;

public interface SaveTaskPort {

  Task saveTask(Task task);

}
