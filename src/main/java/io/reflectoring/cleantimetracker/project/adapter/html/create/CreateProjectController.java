package io.reflectoring.cleantimetracker.project.adapter.html.create;

import javax.validation.Valid;

import io.reflectoring.cleantimetracker.project.domain.usecase.create.CreateProjectUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
class CreateProjectController {

  private CreateProjectUseCase createProjectUseCase;

  CreateProjectController(CreateProjectUseCase createProjectUseCase) {
    this.createProjectUseCase = createProjectUseCase;
  }

  @GetMapping("/projects/create")
  String displayCreateProjectForm(Model model) {
    model.addAttribute("project", new CreateProjectModel());
    return "createProject.html";
  }


  @PostMapping("/projects")
  String createProject(@Valid @ModelAttribute("project") CreateProjectModel projectModel) {
    createProjectUseCase.createProject(projectModel.getName());
    return "redirect:/projects/list";
  }


}
