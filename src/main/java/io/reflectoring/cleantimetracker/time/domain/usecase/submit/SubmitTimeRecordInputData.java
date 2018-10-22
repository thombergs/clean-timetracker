package io.reflectoring.cleantimetracker.time.domain.usecase.submit;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class SubmitTimeRecordInputData {

  private final LocalDate date;

  private final Integer minutes;

  private final Long taskId;

}
