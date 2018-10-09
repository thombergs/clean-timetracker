package io.reflectoring.cleantimetracker.project.adapter.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.reflectoring.cleantimetracker.project.domain.entity.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
class ProjectEntity {

  @Id
  @GeneratedValue
  private Long id;

  @Column
  private String name;

  @Column
  private ProjectStatus status;
}
