package io.reflectoring.cleantimetracker.timecontext.domain.usecase.list;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Parameters to define the filter for loading TimeRecords.
 */
@Data
@Builder
@RequiredArgsConstructor
public class ListTimeRecordsQueryParameters {

  private final LocalDate start;

  private final LocalDate end;

}
