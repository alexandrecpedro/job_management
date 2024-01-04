package br.com.jobmanagement.job_management.exceptions;

public class EntityFoundException extends RuntimeException {
  public EntityFoundException(String entityName) {
    super("%s already exists!".formatted(
        entityName.substring(0, 1).toUpperCase() + entityName.substring(1).toLowerCase()));
  }
}
