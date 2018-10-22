package io.reflectoring.cleantimetracker.timecontext.domain.entity;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimeRecord {

  private TimeRecordId id;

  private Long taskId;

  private LocalDate date;

  private Integer minutes;

  private TimeRecordStatus status;

}
