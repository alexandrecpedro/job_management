package br.com.jobmanagement.job_management.modules.company.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "job")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Schema(example = "e61bf5db-195c-5b8d-a239-e7935612447d", description = "Job's ID")
  private UUID id;

  @Schema(example = "Job position for a designer", description = "Job description")
  private String description;

  @Schema(example = "GymPass, Health Insurance", description = "Job benefits")
  private String benefits;

  @NotBlank(message = "The [level] field is mandatory!")
  @Schema(example = "SENIOR", requiredMode = RequiredMode.REQUIRED, description = "Job level")
  private String level;

  @ManyToOne()
  @JoinColumn(name = "company_id", insertable = false, updatable = false)
  private CompanyEntity companyEntity;

  @Column(name = "company_id", nullable = false)
  @Schema(example = "298ec520-aff7-5cff-9d6c-2e51b85601de", description = "Company's ID")
  private UUID companyId;

  @CreationTimestamp
  @Schema(example = "2023-11-14T19:39:26.732232")
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Schema(example = "2023-09-26T19:38:15.030000")
  private LocalDateTime updatedAt;
}
