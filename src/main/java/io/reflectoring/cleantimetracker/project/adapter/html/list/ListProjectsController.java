package io.reflectoring.cleantimetracker.project.adapter.html.list;

import java.util.List;

import io.reflectoring.cleantimetracker.project.domain.entity.Project;
import io.reflectoring.cleantimetracker.project.domain.usecase.list.ListProjectsUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class ListProjectsController {

  private ListProjectsUseCase listProjectsUseCase;

  private ListProjectModelMapper projectModelMapper;

  ListProjectsController(ListProjectsUseCase listProjectsUseCase, ListProjectModelMapper projectModelMapper) {
    this.listProjectsUseCase = listProjectsUseCase;
    this.projectModelMapper = projectModelMapper;
  }

  @GetMapping("/projects/list")
  String displayProjectsList(Model model) {
    List<Project> projects = listProjectsUseCase.listProjects();
    List<ListProjectModel> projectModels = projectModelMapper.toModels(projects);
    model.addAttribute("projects", projectModels);
    return "listProjects.html";
  }

}
