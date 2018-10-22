package io.reflectoring.cleantimetracker.project.adapter.driving.html.edit;

import io.reflectoring.cleantimetracker.project.domain.entity.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
class TaskModel {

  private Long id;

  private String name;

  private Boolean invoiceable;

  private TaskStatus status;

  public boolean isActive() {
    return this.status == TaskStatus.ACTIVE;
  }

}
