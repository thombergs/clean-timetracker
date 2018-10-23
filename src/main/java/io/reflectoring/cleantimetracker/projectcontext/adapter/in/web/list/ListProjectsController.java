package io.reflectoring.cleantimetracker.projectcontext.adapter.in.web.list;

import java.util.List;

import io.reflectoring.cleantimetracker.projectcontext.domain.entity.Project;
import io.reflectoring.cleantimetracker.projectcontext.domain.entity.ProjectId;
import io.reflectoring.cleantimetracker.projectcontext.domain.usecase.changeprojectstatus.ChangeProjectStatusUseCase;
import io.reflectoring.cleantimetracker.projectcontext.domain.usecase.listprojects.ListProjectsUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
class ListProjectsController {

  private ListProjectsUseCase listProjectsUseCase;

  private ProjectListModelMapper projectListModelMapper;

  private ChangeProjectStatusUseCase changeProjectStatusUseCase;

  ListProjectsController(ListProjectsUseCase listProjectsUseCase, ProjectListModelMapper projectListModelMapper, ChangeProjectStatusUseCase changeProjectStatusUseCase) {
    this.listProjectsUseCase = listProjectsUseCase;
    this.projectListModelMapper = projectListModelMapper;
    this.changeProjectStatusUseCase = changeProjectStatusUseCase;
  }

  @GetMapping(path = {"/projects", "/"})
  String displayProjectsList(Model model) {
    List<Project> projects = listProjectsUseCase.listProjects();
    List<ProjectListModel> projectListModels = projectListModelMapper.toModels(projects);
    model.addAttribute("projects", projectListModels);
    return "project/listProjects.html";
  }

  @PostMapping("/projects/{id}/activate")
  String activateProject(@PathVariable("id") Long projectId) {
    changeProjectStatusUseCase.activateProject(ProjectId.of(projectId));
    return "redirect:/projects";
  }

  @PostMapping("/projects/{id}/deactivate")
  String deactivateProject(@PathVariable("id") Long projectId) {
    changeProjectStatusUseCase.deactivateProject(ProjectId.of(projectId));
    return "redirect:/projects";
  }

}
