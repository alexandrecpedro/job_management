package br.com.jobmanagement.job_management.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.jobmanagement.job_management.exceptions.EntityFoundException;
import br.com.jobmanagement.job_management.modules.company.entities.CompanyEntity;
import br.com.jobmanagement.job_management.modules.company.repositories.ICompanyRepository;

@Service
public class CreateCompanyUseCase {
  @Autowired
  private ICompanyRepository companyRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public CompanyEntity execute(CompanyEntity companyEntity) {
    this.companyRepository
        .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
        .ifPresent(user -> {
          throw new EntityFoundException("Company");
        });

    var password = passwordEncoder.encode(companyEntity.getPassword());
    companyEntity.setPassword(password);

    return this.companyRepository.save(companyEntity);
  }
}
