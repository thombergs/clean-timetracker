package io.reflectoring.cleantimetracker.time.domain.usecase.submit;

public class TooMuchTimePerRecordException extends RuntimeException {

  public TooMuchTimePerRecordException(int bookedMinutes, int maximum){
    super(String.format("cannot book more than %d minutes on a single record (was: %s)", maximum, bookedMinutes));
  }

}
