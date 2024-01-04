package br.com.jobmanagement.job_management.modules.candidate.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

public record AuthCandidateRequestDTO(
    @Schema(example = "maria", requiredMode = RequiredMode.REQUIRED, description = "Candidate's username") String username,

    @Schema(example = "1234567890", requiredMode = RequiredMode.REQUIRED, description = "Candidate's password") String password) {
}
