package br.com.jobmanagement.job_management.modules.company.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jobmanagement.job_management.modules.company.entities.JobEntity;

public interface IJobRepository extends JpaRepository<JobEntity, UUID> {
  List<JobEntity> findByDescriptionContainingIgnoreCase(String title);
}
