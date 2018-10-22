package io.reflectoring.cleantimetracker.projectcontext.adapter.out.persistence;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import io.reflectoring.cleantimetracker.projectcontext.domain.entity.ProjectId;
import io.reflectoring.cleantimetracker.projectcontext.domain.entity.Task;
import io.reflectoring.cleantimetracker.projectcontext.domain.entity.TaskId;
import io.reflectoring.cleantimetracker.projectcontext.domain.entity.TaskStatus;
import io.reflectoring.cleantimetracker.projectcontext.domain.port.out.persistence.CreateTaskPort;
import io.reflectoring.cleantimetracker.projectcontext.domain.port.out.persistence.QueryTasksPort;
import io.reflectoring.cleantimetracker.projectcontext.domain.port.out.persistence.UpdateTaskPort;
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
  public List<Task> listAllTasks() {
    return taskEntityMapper.toDomainObjects(taskEntityRepository.findAll());
  }

  @Override
  public void changeStatus(Task task, TaskStatus status) {
    taskEntityRepository.updateStatus(task.getId().getValue(), status);
  }
}
