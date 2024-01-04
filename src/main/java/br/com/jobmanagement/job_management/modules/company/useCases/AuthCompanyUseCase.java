package br.com.jobmanagement.job_management.modules.company.useCases;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.jobmanagement.job_management.modules.company.dto.AuthCompanyRequestDTO;
import br.com.jobmanagement.job_management.modules.company.dto.AuthCompanyResponseDTO;
import br.com.jobmanagement.job_management.modules.company.repositories.ICompanyRepository;

@Service
public class AuthCompanyUseCase {
  @Value("${security.token.secret}")
  private String secretKey;

  @Autowired
  private ICompanyRepository companyRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public AuthCompanyResponseDTO execute(AuthCompanyRequestDTO authCompanyRequestDTO) throws AuthenticationException {
    var company = this.companyRepository.findByUsername(authCompanyRequestDTO.getUsername()).orElseThrow(() -> {
      throw new UsernameNotFoundException("Username/password incorrect");
    });

    var passwordMatches = this.passwordEncoder.matches(authCompanyRequestDTO.getPassword(), company.getPassword());

    if (!passwordMatches) {
      throw new AuthenticationException();
    }

    Algorithm algorithm = Algorithm.HMAC256(secretKey);

    var expiresIn = Instant.now().plus(Duration.ofMinutes(10));

    var token = JWT.create().withIssuer("javagas")
        .withExpiresAt(expiresIn)
        .withSubject(company.getId().toString())
        .withClaim("roles", Arrays.asList("COMPANY"))
        .sign(algorithm);

    var authCompanyResponseDTO = AuthCompanyResponseDTO.builder()
        .access_token(token)
        .expires_in(expiresIn.toEpochMilli())
        .build();

    return authCompanyResponseDTO;
  }
}
