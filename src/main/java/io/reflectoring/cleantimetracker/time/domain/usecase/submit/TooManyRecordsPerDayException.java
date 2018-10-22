package io.reflectoring.cleantimetracker.time.domain.usecase.submit;

public class TooManyRecordsPerDayException extends RuntimeException {

  public TooManyRecordsPerDayException() {
    super("only one record per day and task is allowed!");
  }

}
