package io.reflectoring.cleantimetracker.project.adapter.driving.html.list;

import io.reflectoring.cleantimetracker.project.domain.entity.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class ProjectListModel {

  private Long id;

  private String name;

  private ProjectStatus status;

  public boolean isActive() {
    return this.status == ProjectStatus.ACTIVE;
  }

}
