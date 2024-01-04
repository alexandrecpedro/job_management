package br.com.jobmanagement.job_management.modules.candidate.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jobmanagement.job_management.modules.candidate.entities.CandidateEntity;

public interface ICandidateRepository extends JpaRepository<CandidateEntity, UUID> {
  Optional<CandidateEntity> findByUsernameOrEmail(String username, String email);

  Optional<CandidateEntity> findByUsername(String username);
}
