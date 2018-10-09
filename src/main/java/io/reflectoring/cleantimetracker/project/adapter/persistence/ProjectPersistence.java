package io.reflectoring.cleantimetracker.project.adapter.persistence;

import java.util.List;
import java.util.Optional;

import io.reflectoring.cleantimetracker.project.domain.entity.Project;
import io.reflectoring.cleantimetracker.project.domain.entity.ProjectId;
import io.reflectoring.cleantimetracker.project.domain.usecase.QueryProjectsPort;
import io.reflectoring.cleantimetracker.project.domain.usecase.SaveProjectPort;
import io.reflectoring.cleantimetracker.project.domain.usecase.create.CreateProjectPort;
import org.springframework.stereotype.Service;

@Service
class ProjectPersistence implements CreateProjectPort, QueryProjectsPort, SaveProjectPort {

  private ProjectRepository projectRepository;

  private ProjectEntityMapper projectEntityMapper;

  ProjectPersistence(ProjectRepository projectRepository, ProjectEntityMapper projectEntityMapper) {
    this.projectRepository = projectRepository;
    this.projectEntityMapper = projectEntityMapper;
  }

  @Override
  public Project createProject(Project project) {
    ProjectEntity entity = projectEntityMapper.toEntity(project);
    ProjectEntity savedEntity = projectRepository.save(entity);
    return projectEntityMapper.toDomainObject(savedEntity);
  }

  @Override
  public List<Project> listProjects() {
    Iterable<ProjectEntity> entities = projectRepository.findAll();
    return projectEntityMapper.toDomainObjects(entities);
  }

  @Override
  public Project findOne(ProjectId projectId) {
    Optional<ProjectEntity> project = projectRepository.findById(projectId.getValue());
    return projectEntityMapper.toDomainObject(project.orElseThrow());
  }


  @Override
  public Project saveProject(Project project) {
    ProjectEntity entity = projectEntityMapper.toEntity(project);
    ProjectEntity savedEntity = projectRepository.save(entity);
    return projectEntityMapper.toDomainObject(savedEntity);
  }
}
