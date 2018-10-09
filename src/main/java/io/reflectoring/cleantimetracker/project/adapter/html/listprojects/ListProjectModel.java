package io.reflectoring.cleantimetracker.project.adapter.html.listprojects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class ListProjectModel {

  private Long id;

  private String name;

}
