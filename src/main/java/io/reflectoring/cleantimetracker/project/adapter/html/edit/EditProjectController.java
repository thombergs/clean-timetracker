package io.reflectoring.cleantimetracker.project.adapter.html.edit;

import java.util.List;

import io.reflectoring.cleantimetracker.project.domain.entity.Project;
import io.reflectoring.cleantimetracker.project.domain.entity.ProjectId;
import io.reflectoring.cleantimetracker.project.domain.entity.Task;
import io.reflectoring.cleantimetracker.project.domain.usecase.addtask.AddTaskUseCase;
import io.reflectoring.cleantimetracker.project.domain.usecase.listtasks.ListTasksUseCase;
import io.reflectoring.cleantimetracker.project.domain.usecase.load.LoadProjectUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
class EditProjectController {

  private ListTasksUseCase listTasksUseCase;

  private LoadProjectUseCase loadProjectUseCase;

  private EditProjectModelMapper editProjectModelMapper;

  private AddTaskUseCase addTaskUseCase;

  EditProjectController(ListTasksUseCase listTasksUseCase, LoadProjectUseCase loadProjectUseCase, EditProjectModelMapper editProjectModelMapper, AddTaskUseCase addTaskUseCase) {
    this.listTasksUseCase = listTasksUseCase;
    this.loadProjectUseCase = loadProjectUseCase;
    this.editProjectModelMapper = editProjectModelMapper;
    this.addTaskUseCase = addTaskUseCase;
  }

  @GetMapping("/projects/{id}")
  String displayProjectForm(@PathVariable("id") Long projectId, Model model) {
    Project project = loadProjectUseCase.loadProject(ProjectId.of(projectId));
    List<Task> tasks = listTasksUseCase.listTasksForProject(ProjectId.of(projectId));
    EditProjectModel projectModel = editProjectModelMapper.toModel(project, tasks);
    model.addAttribute("project", projectModel);
    model.addAttribute("addTaskForm", new AddTaskForm());
    return "editProject.html";
  }

  @PostMapping("/projects/{id}/add-task")
  String addTask(@PathVariable("id") Long projectId,
                 @ModelAttribute("addTaskForm") AddTaskForm form) {
    addTaskUseCase.addTask(form.getName(), form.isInvoiceable(), ProjectId.of(projectId));
    return "redirect:/projects/{id}";
  }


}
