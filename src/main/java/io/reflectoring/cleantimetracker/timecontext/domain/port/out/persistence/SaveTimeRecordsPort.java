package io.reflectoring.cleantimetracker.timecontext.domain.port.out.persistence;

import java.util.List;

import io.reflectoring.cleantimetracker.timecontext.domain.entity.TimeRecord;

public interface SaveTimeRecordsPort {

  void saveTimeRecords(List<TimeRecord> records);

}
