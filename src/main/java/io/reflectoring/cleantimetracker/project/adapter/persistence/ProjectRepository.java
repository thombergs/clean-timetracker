package io.reflectoring.cleantimetracker.project.adapter.persistence;

import io.reflectoring.cleantimetracker.project.domain.entity.ProjectStatus;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

interface ProjectRepository extends CrudRepository<ProjectEntity, Long> {

  @Query("update #{#entityName} p set p.status = :status where p.id = :id")
  @Modifying
  int updateStatus(@Param("id") Long projectId, @Param("status") ProjectStatus projectStatus);

}
