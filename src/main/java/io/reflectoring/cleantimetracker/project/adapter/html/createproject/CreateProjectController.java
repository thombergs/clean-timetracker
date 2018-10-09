package io.reflectoring.cleantimetracker.project.adapter.html.createproject;

import javax.validation.Valid;

import io.reflectoring.cleantimetracker.project.domain.usecase.createproject.CreateProjectUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreateProjectController {

  private CreateProjectUseCase createProjectUseCase;

  public CreateProjectController(CreateProjectUseCase createProjectUseCase) {
    this.createProjectUseCase = createProjectUseCase;
  }

  @GetMapping("/projects/create")
  public String displayCreateProjectForm(Model model) {
    model.addAttribute("project", new CreateProjectModel());
    return "createProject.html";
  }


  @PostMapping("/projects")
  public String createProject(@Valid @ModelAttribute("project") CreateProjectModel projectModel) {
    createProjectUseCase.createProject(projectModel.getName());
    return "redirect:/projects/list";
  }


}
