package io.reflectoring.cleantimetracker.timecontext.adapter.in.web.list;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TimeRecordListModel {

  private LocalDate date;

  private Float hours;

  private String taskName;

}
