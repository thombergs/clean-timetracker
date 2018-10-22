package io.reflectoring.cleantimetracker.projectcontext.adapter.in.web.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class CreateProjectForm {

  private String name;

}
