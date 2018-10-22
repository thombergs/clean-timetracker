package io.reflectoring.cleantimetracker.time.domain.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import io.reflectoring.cleantimetracker.timecontext.domain.entity.TimeRecord;
import io.reflectoring.cleantimetracker.timecontext.domain.entity.TimeRecordId;
import io.reflectoring.cleantimetracker.timecontext.domain.entity.TimeRecordStatus;

public class TimeRecordTestFactory {

  public static List<TimeRecord> defaultRecords(Long... taskIds) {
    List<TimeRecord> records = new ArrayList<>();
    for (Long taskId : taskIds) {
      records.add(TimeRecord.builder()
              .minutes(8 * 60)
              .date(LocalDate.of(2018, 10, 22))
              .status(TimeRecordStatus.OPEN)
              .taskId(taskId)
              .id(TimeRecordId.of(43L))
              .build());
    }
    return records;
  }

}
