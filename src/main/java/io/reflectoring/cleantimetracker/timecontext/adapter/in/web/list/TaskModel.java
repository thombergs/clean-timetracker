package io.reflectoring.cleantimetracker.timecontext.adapter.in.web.list;

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
