package br.com.jobmanagement.job_management.exceptions;

public class EntityNameNotFoundException extends RuntimeException {
  public EntityNameNotFoundException(String entityName) {
    super("%s not found!".formatted(
            entityName.substring(0, 1).toUpperCase() + entityName.substring(1).toLowerCase()));
  }
}
