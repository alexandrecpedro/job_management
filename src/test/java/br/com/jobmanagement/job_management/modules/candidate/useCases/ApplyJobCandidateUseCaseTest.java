package br.com.jobmanagement.job_management.modules.candidate.useCases;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.jobmanagement.job_management.exceptions.EntityNameNotFoundException;
import br.com.jobmanagement.job_management.modules.candidate.entities.ApplyJobEntity;
import br.com.jobmanagement.job_management.modules.candidate.entities.CandidateEntity;
import br.com.jobmanagement.job_management.modules.candidate.repositories.IApplyJobRepository;
import br.com.jobmanagement.job_management.modules.candidate.repositories.ICandidateRepository;
import br.com.jobmanagement.job_management.modules.company.entities.JobEntity;
import br.com.jobmanagement.job_management.modules.company.repositories.IJobRepository;

@ExtendWith(MockitoExtension.class)
class ApplyJobCandidateUseCaseTest {

  @InjectMocks
  private ApplyJobCandidateUseCase applyJobCandidateUseCase;

  @Mock
  private ICandidateRepository candidateRepository;

  @Mock
  private IJobRepository jobRepository;

  @Mock
  private IApplyJobRepository applyJobRepository;

    @Test
    @DisplayName("Should not be able to apply for a job if candidate does not found")
    void should_not_be_able_to_apply_job_with_candidate_not_found() {
    try {
      applyJobCandidateUseCase.execute(null, null);
    } catch (Exception e) {
      assertThat(e).isInstanceOf(EntityNameNotFoundException.class);
    }
  }

    @Test
    @DisplayName("Should not be able to apply for a job if job does not found")
    void should_not_be_able_to_apply_job_with_job_not_found() {
    var idCandidate = UUID.randomUUID();

    var candidate = new CandidateEntity();
    candidate.setId(idCandidate);

    when(candidateRepository.findById(idCandidate)).thenReturn(Optional.of(candidate));

    try {
      applyJobCandidateUseCase.execute(idCandidate, null);
    } catch (Exception e) {
      assertThat(e).isInstanceOf(EntityNameNotFoundException.class);
    }
  }

    @Test
    void should_be_able_to_create_a_new_apply_job() {
    var idCandidate = UUID.randomUUID();
    var idJob = UUID.randomUUID();

    var applyJob = ApplyJobEntity.builder().candidateId(idCandidate)
        .jobId(idJob).build();

    var applyJobCreated = ApplyJobEntity.builder().id(UUID.randomUUID()).build();

    when(candidateRepository.findById(idCandidate)).thenReturn(Optional.of(new CandidateEntity()));
    when(jobRepository.findById(idJob)).thenReturn(Optional.of(new JobEntity()));

    when(applyJobRepository.save(applyJob)).thenReturn(applyJobCreated);

    var result = applyJobCandidateUseCase.execute(idCandidate, idJob);

    assertThat(result).hasFieldOrProperty("id");
    assertNotNull(result.getId());

  }
}
