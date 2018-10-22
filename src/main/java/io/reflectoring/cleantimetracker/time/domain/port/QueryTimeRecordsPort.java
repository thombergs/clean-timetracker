package io.reflectoring.cleantimetracker.time.domain.port;

import java.time.LocalDate;
import java.util.List;

import io.reflectoring.cleantimetracker.time.domain.entity.TimeRecord;

public interface QueryTimeRecordsPort {

  List<TimeRecord> listTimeRecords(LocalDate from, LocalDate until);

}
