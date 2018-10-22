package io.reflectoring.cleantimetracker.time.domain.port;

import java.util.List;

import io.reflectoring.cleantimetracker.time.domain.entity.TimeRecord;

public interface SaveTimeRecordsPort {

  void saveTimeRecords(List<TimeRecord> records);

}
