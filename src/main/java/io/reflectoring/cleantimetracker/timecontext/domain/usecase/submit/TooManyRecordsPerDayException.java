package io.reflectoring.cleantimetracker.timecontext.domain.usecase.submit;

public class TooManyRecordsPerDayException extends RuntimeException {

  public TooManyRecordsPerDayException() {
    super("only one record per day and task is allowed!");
  }

}
