package io.reflectoring.cleantimetracker.timecontext.domain.entity;

public enum TimeRecordStatus {

  /**
   * The record has been created (default state).
   */
  OPEN,

  /**
   * The record has been released by the employee to be approved by the manager.
   */
  RELEASED,

  /**
   * The manager has approved the record.
   */
  APPROVED

}
