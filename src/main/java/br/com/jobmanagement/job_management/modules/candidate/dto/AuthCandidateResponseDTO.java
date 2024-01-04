package br.com.jobmanagement.job_management.modules.candidate.dto;

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
public class AuthCandidateResponseDTO {
  @Schema(example = "bf3d2e75-3626-5367-83b2-4515fca16293", requiredMode = RequiredMode.REQUIRED, description = "Candidate's access token")
  private String access_token;
  @Schema(example = "1700002323762", requiredMode = RequiredMode.REQUIRED, description = "Access token expiration")
  private Long expires_in;
}
