package io.reflectoring.cleantimetracker.timecontext.domain.usecase.list;

import java.time.LocalDate;

public class IntervalEndBeforeStartException extends RuntimeException {

  public IntervalEndBeforeStartException(LocalDate start, LocalDate end) {
    super(String.format("interval start (%s) must be before interval end (%s)", start, end));
  }
}
