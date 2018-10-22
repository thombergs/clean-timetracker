package io.reflectoring.cleantimetracker.projectcontext.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Task {

  private TaskId id;

  private String name;

  private boolean invoiceable;

  private Project project;

  @Builder.Default
  private TaskStatus status = TaskStatus.ACTIVE;

}
