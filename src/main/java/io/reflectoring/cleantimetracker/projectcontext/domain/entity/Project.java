package io.reflectoring.cleantimetracker.projectcontext.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {

  private ProjectId id;

  private String name;

  private ProjectStatus status;

}
