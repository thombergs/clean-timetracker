package io.reflectoring.cleantimetracker.projectcontext.adapter.in.web.edit;

import java.util.List;

import io.reflectoring.cleantimetracker.projectcontext.domain.entity.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class EditProjectModel {

  private Long id;

  private String name;

  private ProjectStatus status;

  private List<TaskModel> tasks;

  public boolean isActive() {
    return this.status == ProjectStatus.ACTIVE;
  }
}
