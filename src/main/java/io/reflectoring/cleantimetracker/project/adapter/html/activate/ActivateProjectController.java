package io.reflectoring.cleantimetracker.project.adapter.html.activate;

import io.reflectoring.cleantimetracker.project.domain.entity.ProjectId;
import io.reflectoring.cleantimetracker.project.domain.usecase.activate.ActivateProjectUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
class ActivateProjectController {

  private ActivateProjectUseCase activateProjectUseCase;

  ActivateProjectController(ActivateProjectUseCase activateProjectUseCase) {
    this.activateProjectUseCase = activateProjectUseCase;
  }


  @PostMapping("/projects/{id}/activate")
  String activateProject(@PathVariable("id") Long projectId) {
    activateProjectUseCase.activateProject(ProjectId.of(projectId));
    return "redirect:/projects/list";
  }

  @PostMapping("/projects/{id}/deactivate")
  String deactivateProject(@PathVariable("id") Long projectId) {
    activateProjectUseCase.deactivateProject(ProjectId.of(projectId));
    return "redirect:/projects/list";
  }


}
