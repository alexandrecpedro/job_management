package br.com.jobmanagement.job_management.modules.company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateJobDTO {
  @NotBlank(message = "The [description] field is mandatory!")
  @Schema(example = "Job opening for junior developer", requiredMode = RequiredMode.REQUIRED, description = "Job description")
  private String description;

  @NotBlank(message = "The [benefits] field is mandatory!")
  @Schema(example = "GymPass, Health Insurance", requiredMode = RequiredMode.REQUIRED, description = "Job benefits")
  private String benefits;

  @NotBlank(message = "The [level] field is mandatory!")
  @Schema(example = "JUNIOR", requiredMode = RequiredMode.REQUIRED, description = "Job level")
  private String level;
}
