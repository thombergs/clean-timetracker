package io.reflectoring.cleantimetracker.time.adapter.driven.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.time.LocalDate;

import io.reflectoring.cleantimetracker.time.domain.entity.TimeRecordStatus;
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
