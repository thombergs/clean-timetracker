package io.reflectoring.cleantimetracker.time.adapter.driven.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import io.reflectoring.cleantimetracker.project.adapter.driving.timecontext.TimeContextAdapter;
import io.reflectoring.cleantimetracker.project.domain.entity.Task;
import io.reflectoring.cleantimetracker.time.domain.entity.TimeTrackingTask;
import io.reflectoring.cleantimetracker.time.domain.port.QueryTasksPort;
import org.springframework.stereotype.Service;

@Service
public class ProjectContextAdapter implements QueryTasksPort {

  private TimeContextAdapter timeContextAdapter;

  private TaskMapper taskMapper;

  public ProjectContextAdapter(TimeContextAdapter timeContextAdapter, TaskMapper taskMapper) {
    this.timeContextAdapter = timeContextAdapter;
    this.taskMapper = taskMapper;
  }

  @Override
  public List<TimeTrackingTask> listByIds(Set<Long> taskIds) {
    List<Task> tasks = timeContextAdapter.listTasksByIds(new ArrayList<>(taskIds));
    return taskMapper.toTimeTrackingTasks(tasks);
  }

  @Override
  public TimeTrackingTask loadTask(Long taskId) {
    Optional<Task> task = timeContextAdapter.loadTask(taskId);
    if (task.isPresent()) {
      return taskMapper.toTimeTrackingTask(task.get());
    } else {
      return null;
    }
  }

}
