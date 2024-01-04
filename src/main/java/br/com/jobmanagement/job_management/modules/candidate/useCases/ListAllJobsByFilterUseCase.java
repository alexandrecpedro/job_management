package br.com.jobmanagement.job_management.modules.candidate.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jobmanagement.job_management.modules.company.entities.JobEntity;
import br.com.jobmanagement.job_management.modules.company.repositories.IJobRepository;

@Service
public class ListAllJobsByFilterUseCase {
  @Autowired
  private IJobRepository jobRepository;

  public List<JobEntity> execute(String filter) {
    return this.jobRepository.findByDescriptionContainingIgnoreCase(filter);
  }
}
