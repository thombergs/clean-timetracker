package io.reflectoring.cleantimetracker.project.adapter.driven.persistence;

import java.util.List;
import java.util.Optional;

import io.reflectoring.cleantimetracker.project.domain.entity.Project;
import io.reflectoring.cleantimetracker.project.domain.entity.ProjectId;
import io.reflectoring.cleantimetracker.project.domain.entity.ProjectStatus;
import io.reflectoring.cleantimetracker.project.domain.port.driven.persistence.CreateProjectPort;
import io.reflectoring.cleantimetracker.project.domain.port.driven.persistence.QueryProjectsPort;
import io.reflectoring.cleantimetracker.project.domain.port.driven.persistence.UpdateProjectPort;
import org.springframework.stereotype.Service;

@Service
class ProjectPersistenceAdapter implements CreateProjectPort, QueryProjectsPort, UpdateProjectPort {

  private ProjectRepository projectRepository;

  private ProjectEntityMapper projectEntityMapper;

  ProjectPersistenceAdapter(ProjectRepository projectRepository, ProjectEntityMapper projectEntityMapper) {
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
  public Optional<Project> findOne(ProjectId projectId) {
    Optional<ProjectEntity> optionalProject = projectRepository.findById(projectId.getValue());
    return optionalProject.map(projectEntity -> projectEntityMapper.toDomainObject(projectEntity));
  }

  @Override
  public void changeStatus(Project project, ProjectStatus status) {
    projectRepository.updateStatus(project.getId().getValue(), status);
  }
}
