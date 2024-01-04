package br.com.jobmanagement.job_management.modules.candidate.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jobmanagement.job_management.exceptions.EntityNameNotFoundException;
import br.com.jobmanagement.job_management.modules.candidate.entities.ApplyJobEntity;
import br.com.jobmanagement.job_management.modules.candidate.repositories.IApplyJobRepository;
import br.com.jobmanagement.job_management.modules.candidate.repositories.ICandidateRepository;
import br.com.jobmanagement.job_management.modules.company.repositories.IJobRepository;

@Service
public class ApplyJobCandidateUseCase {
  @Autowired
  private ICandidateRepository candidateRepository;

  @Autowired
  private IJobRepository jobRepository;

  @Autowired
  private IApplyJobRepository applyJobRepository;

  // Candidate's ID
  // Job's ID
  public ApplyJobEntity execute(UUID idCandidate, UUID idJob) {
    // Validate if candidate exists
    this.candidateRepository.findById(idCandidate)
        .orElseThrow(() -> {
          throw new EntityNameNotFoundException("user");
        });

    // Validate if job exists
    this.jobRepository.findById(idJob)
        .orElseThrow(() -> {
          throw new EntityNameNotFoundException("job");
        });

    // Candidate apply to a job
    var applyJob = ApplyJobEntity.builder()
        .candidateId(idCandidate)
        .jobId(idJob).build();

    applyJob = applyJobRepository.save(applyJob);
    return applyJob;
  }
}
