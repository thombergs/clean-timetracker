package io.reflectoring.cleantimetracker.project.adapter.html.listprojects;

import java.util.List;

import io.reflectoring.cleantimetracker.project.adapter.html.ProjectModel;
import io.reflectoring.cleantimetracker.project.adapter.html.ProjectModelMapper;
import io.reflectoring.cleantimetracker.project.domain.entity.Project;
import io.reflectoring.cleantimetracker.project.domain.usecase.listprojects.ListProjectsUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListProjectsController {

  private ListProjectsUseCase listProjectsUseCase;

  private ProjectModelMapper projectModelMapper;

  public ListProjectsController(ListProjectsUseCase listProjectsUseCase, ProjectModelMapper projectModelMapper) {
    this.listProjectsUseCase = listProjectsUseCase;
    this.projectModelMapper = projectModelMapper;
  }

  @GetMapping("/projects/list")
  public String displayProjectsList(Model model) {
    List<Project> projects = listProjectsUseCase.listProjects();
    List<ProjectModel> projectModels = projectModelMapper.toModels(projects);
    model.addAttribute("projects", projectModels);
    return "listProjects.html";
  }

}
