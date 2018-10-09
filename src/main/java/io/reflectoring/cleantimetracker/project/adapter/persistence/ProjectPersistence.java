package io.reflectoring.cleantimetracker.project.adapter.persistence;

import java.util.List;

import io.reflectoring.cleantimetracker.project.domain.entity.Project;
import io.reflectoring.cleantimetracker.project.domain.usecase.createproject.CreateProjectPort;
import io.reflectoring.cleantimetracker.project.domain.usecase.listprojects.ListProjectsPort;
import org.springframework.stereotype.Service;

@Service
public class ProjectPersistence implements CreateProjectPort, ListProjectsPort {

  private ProjectRepository projectRepository;

  private ProjectEntityMapper projectEntityMapper;

  public ProjectPersistence(ProjectRepository projectRepository, ProjectEntityMapper projectEntityMapper) {
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


}
