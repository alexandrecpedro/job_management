package br.com.jobmanagement.job_management.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jobmanagement.job_management.exceptions.EntityNameNotFoundException;
import br.com.jobmanagement.job_management.modules.company.entities.JobEntity;
import br.com.jobmanagement.job_management.modules.company.repositories.ICompanyRepository;
import br.com.jobmanagement.job_management.modules.company.repositories.IJobRepository;

@Service
public class CreateJobUseCase {
  @Autowired
  private IJobRepository jobRepository;

  @Autowired
  private ICompanyRepository companyRepository;

  public JobEntity execute(JobEntity jobEntity) {
    companyRepository.findById(jobEntity.getCompanyId()).orElseThrow(() -> {
      throw new EntityNameNotFoundException("company");
    });

    return this.jobRepository.save(jobEntity);
  }
}
