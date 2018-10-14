package io.reflectoring.cleantimetracker.project.adapter.persistence;

import io.reflectoring.cleantimetracker.project.domain.entity.Project;
import io.reflectoring.cleantimetracker.project.domain.entity.ProjectId;
import io.reflectoring.cleantimetracker.project.domain.entity.Task;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Java6Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import({ProjectEntityMapper.class, TaskPersistence.class, TaskEntityMapper.class, ProjectEntityTestData.class})
class TaskPersistenceIntegrationTest {

  @Autowired
  private TaskEntityRepository taskEntityRepository;

  @Autowired
  private TaskPersistence taskPersistence;

  @Autowired
  private ProjectEntityTestData projectEntityTestData;

  @Test
  @Sql(ProjectEntityTestData.SQL)
  void savesNewTask() {
    ProjectEntity project = projectEntityTestData.defaultProject();
    Task task = Task.builder()
            .name("Task")
            .project(Project.builder()
                    .id(ProjectId.of(project.getId()))
                    .build())
            .build();
    Task savedTask = taskPersistence.saveTask(task);
    assertThat(savedTask.getId()).isNotNull();
  }

}