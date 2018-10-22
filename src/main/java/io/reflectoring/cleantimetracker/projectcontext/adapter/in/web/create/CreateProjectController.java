package io.reflectoring.cleantimetracker.projectcontext.adapter.in.web.create;

import io.reflectoring.cleantimetracker.projectcontext.domain.usecase.createproject.CreateProjectUseCase;
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
    model.addAttribute("project", new CreateProjectForm());
    return "project/createProject.html";
  }


  @PostMapping("/projects")
  String createProject(@ModelAttribute("project") CreateProjectForm projectModel) {
    createProjectUseCase.createProject(projectModel.getName());
    return "redirect:/projects";
  }


}
