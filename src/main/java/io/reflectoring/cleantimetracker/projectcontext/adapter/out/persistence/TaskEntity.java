package io.reflectoring.cleantimetracker.projectcontext.adapter.out.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import io.reflectoring.cleantimetracker.projectcontext.domain.entity.TaskStatus;
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
