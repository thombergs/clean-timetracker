package io.reflectoring.cleantimetracker.project.adapter.html;

import javax.validation.Valid;

import io.reflectoring.cleantimetracker.project.domain.entity.Project;
import io.reflectoring.cleantimetracker.project.domain.usecase.createproject.CreateProjectUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreateProjectController {

  private CreateProjectUseCase createProjectUseCase;

  private ProjectModelMapper projectModelMapper;

  public CreateProjectController(CreateProjectUseCase createProjectUseCase, ProjectModelMapper projectModelMapper) {
    this.createProjectUseCase = createProjectUseCase;
    this.projectModelMapper = projectModelMapper;
  }

  @GetMapping("/projects/create")
  public String displayCreateProjectForm(Model model) {
    model.addAttribute("project", new ProjectModel());
    return "createProject.html";
  }


  @PostMapping("/projects")
  public String createProject(@Valid @ModelAttribute("project") ProjectModel projectModel, Model model) {
    Project project = projectModelMapper.toDomainObject(projectModel);
    createProjectUseCase.createProject(project);
    return "redirect:/projects/list";
  }


}
