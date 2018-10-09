package io.reflectoring.cleantimetracker.project.adapter.persistence;

import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<ProjectEntity, Long> {
}
