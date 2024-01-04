package br.com.jobmanagement.job_management.modules.company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthCompanyResponseDTO {
  @Schema(example = "f4bd0071-8da8-53d5-89c5-7ebbc4fd4c09", requiredMode = RequiredMode.REQUIRED, description = "Company's access token")
  private String access_token;
  @Schema(example = "1700002323762", requiredMode = RequiredMode.REQUIRED, description = "Access token expiration")
  private Long expires_in;
}
