package io.reflectoring.cleantimetracker.timecontext.domain.port.out.persistence;

import java.time.LocalDate;
import java.util.List;

import io.reflectoring.cleantimetracker.timecontext.domain.entity.TimeRecord;

public interface QueryTimeRecordsPort {

  List<TimeRecord> listTimeRecords(LocalDate from, LocalDate until);

}
