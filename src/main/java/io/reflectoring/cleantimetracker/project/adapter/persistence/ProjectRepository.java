package io.reflectoring.cleantimetracker.project.adapter.persistence;

import org.springframework.data.repository.CrudRepository;

interface ProjectRepository extends CrudRepository<ProjectEntity, Long> {
}
