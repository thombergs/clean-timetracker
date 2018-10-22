package io.reflectoring.cleantimetracker.time.adapter.driven.persistence;

import java.util.ArrayList;
import java.util.List;

import io.reflectoring.cleantimetracker.time.domain.entity.TimeRecord;
import io.reflectoring.cleantimetracker.time.domain.entity.TimeRecordId;
import org.springframework.stereotype.Component;

@Component
public class TimeRecordMapper {

  public TimeRecord toDomainObject(TimeRecordEntity entity) {
    return TimeRecord.builder()
            .status(entity.getStatus())
            .minutes(entity.getMinutes())
            .date(entity.getDate())
            .taskId(entity.getTaskId())
            .id(TimeRecordId.of(entity.getId()))
            .build();
  }

  public List<TimeRecord> toDomainObjects(List<TimeRecordEntity> entities) {
    List<TimeRecord> domainObjects = new ArrayList<>();
    for (TimeRecordEntity entity : entities) {
      domainObjects.add(toDomainObject(entity));
    }
    return domainObjects;
  }

  public TimeRecordEntity toEntity(TimeRecord domainObject) {
    return TimeRecordEntity.builder()
            .status(domainObject.getStatus())
            .minutes(domainObject.getMinutes())
            .date(domainObject.getDate())
            .taskId(domainObject.getTaskId())
            .id(domainObject.getId().getValue())
            .build();
  }

  public List<TimeRecordEntity> toEntities(List<TimeRecord> domainObjects) {
    List<TimeRecordEntity> entities = new ArrayList<>();
    for (TimeRecord domainObject : domainObjects) {
      entities.add(toEntity(domainObject));
    }
    return entities;
  }

}
