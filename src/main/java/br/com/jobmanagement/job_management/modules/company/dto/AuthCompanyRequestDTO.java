package br.com.jobmanagement.job_management.modules.company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthCompanyRequestDTO {
  @Schema(example = "java_company", requiredMode = RequiredMode.REQUIRED, description = "Company's username")
  private String username;
  @Schema(example = "1234567890", requiredMode = RequiredMode.REQUIRED, description = "Company's password")
  private String password;
}
