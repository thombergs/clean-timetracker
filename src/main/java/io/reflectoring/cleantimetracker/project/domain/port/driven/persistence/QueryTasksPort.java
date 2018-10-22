package io.reflectoring.cleantimetracker.project.domain.port.driven.persistence;

import java.util.List;
import java.util.Optional;

import io.reflectoring.cleantimetracker.project.domain.entity.ProjectId;
import io.reflectoring.cleantimetracker.project.domain.entity.Task;
import io.reflectoring.cleantimetracker.project.domain.entity.TaskId;

public interface QueryTasksPort {

  List<Task> listTasksForProject(ProjectId projectId);

  Optional<Task> findOne(TaskId taskId);

  List<Task> listByIds(List<TaskId> taskIds);

}
