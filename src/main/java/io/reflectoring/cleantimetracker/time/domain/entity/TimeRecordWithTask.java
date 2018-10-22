package io.reflectoring.cleantimetracker.time.domain.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimeRecordWithTask extends TimeRecord {

  private TimeTrackingTask task;

  public static TimeRecordWithTask fromTimeRecord(TimeRecord record, TimeTrackingTask task) {
    TimeRecordWithTask timeRecordWithTask = new TimeRecordWithTask();
    timeRecordWithTask.setDate(record.getDate());
    timeRecordWithTask.setMinutes(record.getMinutes());
    timeRecordWithTask.setTaskId(record.getTaskId());
    timeRecordWithTask.setStatus(record.getStatus());
    timeRecordWithTask.setTask(task);
    return timeRecordWithTask;
  }

}
