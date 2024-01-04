package br.com.jobmanagement.job_management.modules.candidate.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import br.com.jobmanagement.job_management.modules.company.entities.JobEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "apply_jobs")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplyJobEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Schema(example = "1aa355b0-43c0-5d03-bcbb-4bff39e0e46e", description = "Apply Job's ID")
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "candidate_id", insertable = false, updatable = false)
  private CandidateEntity candidateEntity;

  @ManyToOne
  @JoinColumn(name = "job_id", insertable = false, updatable = false)
  private JobEntity jobEntity;

  @Column(name = "candidate_id")
  @Schema(example = "ee98d7c2-78fa-546f-86f8-7cb6f4a24b46", description = "Candidate's ID")
  private UUID candidateId;

  @Column(name = "job_id")
  @Schema(example = "e61bf5db-195c-5b8d-a239-e7935612447d", description = "Job's ID")
  private UUID jobId;

  @CreationTimestamp
  @Schema(example = "2023-11-14T19:39:26.732232")
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Schema(example = "2023-09-26T19:38:15.030000")
  private LocalDateTime updatedAt;
}
