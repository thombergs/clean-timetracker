package io.reflectoring.cleantimetracker.time.domain.entity;

import java.util.ArrayList;
import java.util.List;

import io.reflectoring.cleantimetracker.timecontext.domain.entity.TimeTrackingTask;

public class TimeTrackingTaskTestFactory {

  public static List<TimeTrackingTask> defaultTasks(Long... taskIds) {
    List<TimeTrackingTask> tasks = new ArrayList<>();
    for (Long taskId : taskIds) {
      tasks.add(defaultTask(taskId));
    }
    return tasks;
  }

  public static TimeTrackingTask defaultTask(Long taskId) {
    return TimeTrackingTask.builder()
            .active(Boolean.TRUE)
            .id(taskId)
            .invoiceable(Boolean.TRUE)
            .name("Task " + taskId)
            .projectId(42L)
            .projectName("Project 42")
            .build();
  }

}
