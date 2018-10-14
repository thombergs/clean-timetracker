package io.reflectoring.cleantimetracker.project.adapter.persistence;

import java.util.List;

import io.reflectoring.cleantimetracker.project.domain.entity.ProjectId;
import io.reflectoring.cleantimetracker.project.domain.entity.Task;
import io.reflectoring.cleantimetracker.project.domain.usecase.ListTasksPort;
import io.reflectoring.cleantimetracker.project.domain.usecase.SaveTaskPort;
import org.springframework.stereotype.Service;

@Service
class TaskPersistence implements SaveTaskPort, ListTasksPort {

  private TaskEntityRepository taskEntityRepository;

  private TaskEntityMapper taskEntityMapper;

  public TaskPersistence(TaskEntityRepository taskEntityRepository, TaskEntityMapper taskEntityMapper) {
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
}
