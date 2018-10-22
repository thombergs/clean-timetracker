package io.reflectoring.cleantimetracker.projectcontext.domain.entity;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class TaskId implements Serializable {

  private final Long value;

  public static TaskId of(Long id) {
    return new TaskId(id);
  }

}
