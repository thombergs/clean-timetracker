package io.reflectoring.cleantimetracker.timecontext.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Different view on the project and task data to be used by the "time tracking" bounded context.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TimeTrackingTask {

  private Long id;

  private String name;

  private Long projectId;

  private String projectName;

  private Boolean active;

  private Boolean invoiceable;

}
