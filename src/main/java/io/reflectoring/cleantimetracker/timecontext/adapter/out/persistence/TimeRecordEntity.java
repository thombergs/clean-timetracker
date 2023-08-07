package io.reflectoring.cleantimetracker.timecontext.adapter.out.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

import io.reflectoring.cleantimetracker.timecontext.domain.entity.TimeRecordStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TIME_RECORD")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimeRecordEntity {

  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "DATE")
  private LocalDate date;

  @Column(name = "MINUTES")
  private Integer minutes;

  @Column(name = "STATUS")
  @Enumerated(EnumType.STRING)
  private TimeRecordStatus status;

  @Column(name = "TASK_ID")
  private Long taskId;

}
