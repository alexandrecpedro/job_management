package br.com.jobmanagement.job_management.modules.candidate.dto;

import java.util.UUID;

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
public class ProfileCandidateResponseDTO {
  @Schema(example = "9a83304c-e670-51ed-b8b7-67cea08eb1a3", requiredMode = RequiredMode.REQUIRED, description = "Candidate's ID")
  private UUID id;

  @Schema(example = "Maria de Souza", requiredMode = RequiredMode.REQUIRED, description = "Candidate's name")
  private String name;

  @Schema(example = "maria", requiredMode = RequiredMode.REQUIRED, description = "Candidate's username")
  private String username;

  @Schema(example = "maria@gmail.com", requiredMode = RequiredMode.REQUIRED, description = "Candidate's email")
  private String email;

  @Schema(example = "Java developer", requiredMode = RequiredMode.REQUIRED, description = "Candidate's profile description")
  private String description;
}
