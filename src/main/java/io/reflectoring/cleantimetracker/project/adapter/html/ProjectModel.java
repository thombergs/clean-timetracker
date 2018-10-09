package io.reflectoring.cleantimetracker.project.adapter.html;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectModel {

  private Long id;

  private String name;

}
