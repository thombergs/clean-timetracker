package io.reflectoring.cleantimetracker.project.adapter.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

interface TaskEntityRepository extends CrudRepository<TaskEntity, Long> {

  List<TaskEntity> findByProjectId(long projectId);

}
