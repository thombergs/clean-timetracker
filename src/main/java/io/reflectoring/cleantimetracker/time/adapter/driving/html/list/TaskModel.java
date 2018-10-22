package io.reflectoring.cleantimetracker.time.adapter.driving.html.list;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Builder
public class TaskModel {

  private final Long id;

  private final String name;

}
