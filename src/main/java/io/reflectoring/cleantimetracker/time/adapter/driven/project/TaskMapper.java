package io.reflectoring.cleantimetracker.time.adapter.driven.project;

import java.util.List;
import java.util.stream.Collectors;

import io.reflectoring.cleantimetracker.project.domain.entity.Task;
import io.reflectoring.cleantimetracker.project.domain.entity.TaskStatus;
import io.reflectoring.cleantimetracker.time.domain.entity.TimeTrackingTask;
import org.springframework.stereotype.Component;

@Component
class TaskMapper {

  TimeTrackingTask toTimeTrackingTask(Task task) {
    return TimeTrackingTask.builder()
            .projectName(task.getProject().getName())
            .name(task.getName())
            .invoiceable(task.isInvoiceable())
            .id(task.getId().getValue())
            .active(task.getStatus() == TaskStatus.ACTIVE)
            .projectId(task.getProject().getId().getValue())
            .build();
  }

  List<TimeTrackingTask> toTimeTrackingTasks(List<Task> tasks) {
    return tasks.stream()
            .map(this::toTimeTrackingTask)
            .collect(Collectors.toList());
  }

}
