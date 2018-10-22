package io.reflectoring.cleantimetracker.project.adapter.driven.persistence;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import io.reflectoring.cleantimetracker.project.domain.entity.ProjectId;
import io.reflectoring.cleantimetracker.project.domain.entity.Task;
import io.reflectoring.cleantimetracker.project.domain.entity.TaskId;
import io.reflectoring.cleantimetracker.project.domain.entity.TaskStatus;
import io.reflectoring.cleantimetracker.project.domain.port.driven.persistence.CreateTaskPort;
import io.reflectoring.cleantimetracker.project.domain.port.driven.persistence.QueryTasksPort;
import io.reflectoring.cleantimetracker.project.domain.port.driven.persistence.UpdateTaskPort;
import org.springframework.stereotype.Service;

@Service
class TaskPersistenceAdapter implements CreateTaskPort, QueryTasksPort, UpdateTaskPort {

  private TaskEntityRepository taskEntityRepository;

  private TaskEntityMapper taskEntityMapper;

  public TaskPersistenceAdapter(TaskEntityRepository taskEntityRepository, TaskEntityMapper taskEntityMapper) {
    this.taskEntityRepository = taskEntityRepository;
    this.taskEntityMapper = taskEntityMapper;
  }

  @Override
  public Task saveTask(Task task) {
    TaskEntity entity = taskEntityMapper.toEntity(task);
    TaskEntity savedEntity = taskEntityRepository.save(entity);
    return taskEntityMapper.toDomainObject(savedEntity);
  }

  @Override
  public List<Task> listTasksForProject(ProjectId projectId) {
    List<TaskEntity> tasks = taskEntityRepository.findByProjectId(projectId.getValue());
    return taskEntityMapper.toDomainObjects(tasks);
  }

  @Override
  public Optional<Task> findOne(TaskId taskId) {
    return taskEntityRepository.findById(taskId.getValue())
            .map((entity -> taskEntityMapper.toDomainObject(entity)));
  }

  @Override
  public List<Task> listByIds(List<TaskId> taskIds) {
    List<TaskEntity> taskEntities = taskEntityRepository.findByIdIn(taskIds.stream()
            .map(TaskId::getValue)
            .collect(Collectors.toList()));
    return taskEntityMapper.toDomainObjects(taskEntities);
  }

  @Override
  public void changeStatus(Task task, TaskStatus status) {
    taskEntityRepository.updateStatus(task.getId().getValue(), status);
  }
}
