package io.reflectoring.cleantimetracker.project.domain.usecase.listtasks;

import java.util.List;

import io.reflectoring.cleantimetracker.project.domain.entity.ProjectId;
import io.reflectoring.cleantimetracker.project.domain.entity.Task;

public interface ListTasksPort {

  List<Task> listTasksForProject(ProjectId projectId);

}
