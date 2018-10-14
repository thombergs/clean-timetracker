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

  private ProjectListModelMapper projectListModelMapper;

  ListProjectsController(ListProjectsUseCase listProjectsUseCase, ProjectListModelMapper projectListModelMapper) {
    this.listProjectsUseCase = listProjectsUseCase;
    this.projectListModelMapper = projectListModelMapper;
  }

  @GetMapping("/projects/list")
  String displayProjectsList(Model model) {
    List<Project> projects = listProjectsUseCase.listProjects();
    List<ProjectListModel> projectListModels = projectListModelMapper.toModels(projects);
    model.addAttribute("projects", projectListModels);
    return "listProjects.html";
  }

}
