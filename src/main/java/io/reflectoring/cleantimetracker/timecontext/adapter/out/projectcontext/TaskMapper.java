package io.reflectoring.cleantimetracker.timecontext.adapter.out.projectcontext;

import java.util.List;
import java.util.stream.Collectors;

import io.reflectoring.cleantimetracker.projectcontext.domain.entity.Task;
import io.reflectoring.cleantimetracker.projectcontext.domain.entity.TaskStatus;
import io.reflectoring.cleantimetracker.timecontext.domain.entity.TimeTrackingTask;
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
