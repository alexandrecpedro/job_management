package br.com.jobmanagement.job_management.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.jobmanagement.job_management.exceptions.EntityFoundException;
import br.com.jobmanagement.job_management.modules.candidate.entities.CandidateEntity;
import br.com.jobmanagement.job_management.modules.candidate.repositories.ICandidateRepository;

@Service
public class CreateCandidateUseCase {
  @Autowired
  private ICandidateRepository candidateRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public CandidateEntity execute(CandidateEntity candidateEntity) {
    this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(),
        candidateEntity.getEmail()).ifPresent(user -> {
          throw new EntityFoundException("Candidate");
        });

    var password = passwordEncoder.encode(candidateEntity.getPassword());
    candidateEntity.setPassword(password);

    return this.candidateRepository.save(candidateEntity);
  }
}
