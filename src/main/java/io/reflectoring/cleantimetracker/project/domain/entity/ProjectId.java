package io.reflectoring.cleantimetracker.project.domain.entity;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ProjectId implements Serializable {

  private final Long value;

  public static ProjectId of(Long id) {
    return new ProjectId(id);
  }

}
