package io.reflectoring.cleantimetracker.time.adapter.driven.persistence;

import java.time.LocalDate;
import java.util.List;

import io.reflectoring.cleantimetracker.time.domain.entity.TimeRecord;
import io.reflectoring.cleantimetracker.time.domain.port.QueryTimeRecordsPort;
import io.reflectoring.cleantimetracker.time.domain.port.SaveTimeRecordsPort;
import org.springframework.stereotype.Component;

@Component
public class TimeRecordPersistenceAdapter implements QueryTimeRecordsPort, SaveTimeRecordsPort {

  private TimeRecordMapper timeRecordMapper;

  private TimeRecordRepository timeRecordRepository;

  public TimeRecordPersistenceAdapter(TimeRecordMapper timeRecordMapper, TimeRecordRepository timeRecordRepository) {
    this.timeRecordMapper = timeRecordMapper;
    this.timeRecordRepository = timeRecordRepository;
  }

  @Override
  public List<TimeRecord> listTimeRecords(LocalDate from, LocalDate until) {
    List<TimeRecordEntity> recordEntities = timeRecordRepository.findByDateBetween(from, until);
    return timeRecordMapper.toDomainObjects(recordEntities);
  }

  @Override
  public void saveTimeRecords(List<TimeRecord> records) {
    List<TimeRecordEntity> recordEntities = timeRecordMapper.toEntities(records);
    timeRecordRepository.saveAll(recordEntities);
  }
}
