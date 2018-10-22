package io.reflectoring.cleantimetracker.time.domain.port;

import java.util.List;
import java.util.Set;

import io.reflectoring.cleantimetracker.time.domain.entity.TimeTrackingTask;

public interface QueryTasksPort {

  List<TimeTrackingTask> listByIds(Set<Long> taskIds);

  TimeTrackingTask loadTask(Long taskId);

}
