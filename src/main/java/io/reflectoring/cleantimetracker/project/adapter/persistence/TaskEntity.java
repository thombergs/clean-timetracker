package io.reflectoring.cleantimetracker.project.adapter.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.reflectoring.cleantimetracker.project.domain.entity.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TASK")
class TaskEntity {

  @Id
  @GeneratedValue
  @Column(name = "ID")
  private Long id;

  @Column(name = "NAME")
  private String name;

  @Column(name = "INVOICEABLE")
  private Boolean invoiceable;

  @ManyToOne(optional = false)
  @JoinColumn(name = "PROJECT_ID")
  private ProjectEntity project;

  @Enumerated(EnumType.STRING)
  @Column(name = "status")
  private TaskStatus status;

}
