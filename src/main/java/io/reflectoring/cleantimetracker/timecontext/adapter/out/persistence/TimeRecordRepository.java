package io.reflectoring.cleantimetracker.timecontext.adapter.out.persistence;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TimeRecordRepository extends CrudRepository<TimeRecordEntity, Long> {

  List<TimeRecordEntity> findByDateBetween(LocalDate start, LocalDate end);

}
