package io.reflectoring.cleantimetracker.time.domain.usecase.submit;

import java.time.LocalDate;

public class TooMuchTimePerDayException extends RuntimeException {

  public TooMuchTimePerDayException(int bookedMinutes, LocalDate date, int maximum) {
    super(String.format("cannot book more than %d minutes on day %s (was: %s)", maximum, date, bookedMinutes));
  }

}
