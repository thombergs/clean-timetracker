package io.reflectoring.cleantimetracker.project.adapter.persistence;

import java.util.List;

import io.reflectoring.cleantimetracker.project.domain.entity.TaskStatus;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

interface TaskEntityRepository extends CrudRepository<TaskEntity, Long> {

  List<TaskEntity> findByProjectId(long projectId);

  @Query("update #{#entityName} t set t.status = :status where t.id = :id")
  @Modifying
  int updateStatus(@Param("id") Long taskId, @Param("status") TaskStatus taskStatus);

}
