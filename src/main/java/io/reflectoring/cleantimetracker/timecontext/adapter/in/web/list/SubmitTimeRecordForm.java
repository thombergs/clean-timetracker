package io.reflectoring.cleantimetracker.timecontext.adapter.in.web.list;

import javax.validation.constraints.NotNull;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubmitTimeRecordForm {

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @NotNull
  private LocalDate date;

  @NotNull
  private Long taskId;

  @NotNull
  private Float hours;

}
