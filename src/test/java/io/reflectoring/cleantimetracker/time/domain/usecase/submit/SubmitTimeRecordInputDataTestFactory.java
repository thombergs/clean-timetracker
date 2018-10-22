package io.reflectoring.cleantimetracker.time.domain.usecase.submit;

import java.time.LocalDate;

class SubmitTimeRecordInputDataTestFactory {

  static SubmitTimeRecordInputData eightHours() {
    return eightHours(42L);
  }

  static SubmitTimeRecordInputData eightHours(Long taskId) {
    return SubmitTimeRecordInputData.builder()
            .date(LocalDate.of(2018, 10, 20))
            .minutes(8 * 60)
            .taskId(taskId)
            .build();
  }

  static SubmitTimeRecordInputData thirteenHours(Long taskId) {
    return SubmitTimeRecordInputData.builder()
            .date(LocalDate.of(2018, 10, 20))
            .minutes(13 * 60)
            .taskId(taskId)
            .build();
  }

}
