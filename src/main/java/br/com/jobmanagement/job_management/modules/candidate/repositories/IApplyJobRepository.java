package br.com.jobmanagement.job_management.modules.candidate.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jobmanagement.job_management.modules.candidate.entities.ApplyJobEntity;

public interface IApplyJobRepository extends JpaRepository<ApplyJobEntity, UUID> {
}
