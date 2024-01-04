package br.com.jobmanagement.job_management.modules.candidate.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jobmanagement.job_management.exceptions.EntityNameNotFoundException;
import br.com.jobmanagement.job_management.modules.candidate.dto.ProfileCandidateResponseDTO;
import br.com.jobmanagement.job_management.modules.candidate.dto.ProfileCandidateResponseDTO.ProfileCandidateResponseDTOBuilder;
import br.com.jobmanagement.job_management.modules.candidate.repositories.ICandidateRepository;

@Service
public class ProfileCandidateUseCase {
  @Autowired
  private ICandidateRepository candidateRepository;

  public ProfileCandidateResponseDTOBuilder execute(UUID idCandidate) {
    var candidate = this.candidateRepository.findById(idCandidate)
        .orElseThrow(() -> {
          throw new EntityNameNotFoundException("Candidate");
        });

    var candidateDTO = ProfileCandidateResponseDTO.builder()
        .description(candidate.getDescription())
        .username(candidate.getUsername())
        .email(candidate.getEmail())
        .name(candidate.getName())
        .id(candidate.getId());

    return candidateDTO;
  }
}
