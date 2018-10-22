package io.reflectoring.cleantimetracker.timecontext.domain.entity;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class TimeRecordId implements Serializable {

  private final Long value;

  public static TimeRecordId of(Long id) {
    return new TimeRecordId(id);
  }

}
