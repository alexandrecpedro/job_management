package br.com.jobmanagement.job_management.modules.candidate.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "candidate")
public class CandidateEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Schema(example = "ee98d7c2-78fa-546f-86f8-7cb6f4a24b46", description = "Candidate's ID")
  private UUID id;

  @NotBlank(message = "The field [name] is mandatory!")
  @Schema(example = "Daniel de Souza", requiredMode = RequiredMode.REQUIRED, description = "Candidate's name")
  private String name;

  @NotBlank(message = "The field [username] is mandatory!")
  @Pattern(regexp = "\\S+", message = "The [username] field must not contain spaces!")
  @Schema(example = "daniel", requiredMode = RequiredMode.REQUIRED, description = "Candidate's username")
  private String username;

  @Email(message = "The [email] field must be a valid e-mail!")
  @Schema(example = "daniel@gmail.com", requiredMode = RequiredMode.REQUIRED, description = "Candidate's e-mail")
  private String email;

  @Length(min = 10, max = 100, message = "The password must contain between (10) and (100) characters!")
  @Schema(example = "port@98172", minLength = 10, maxLength = 100, requiredMode = RequiredMode.REQUIRED, description = "Candidate's password")
  private String password;

  @Schema(example = "Java developer", requiredMode = RequiredMode.REQUIRED, description = "Candidate's brief description")
  private String description;

  @Schema(example = "Backend: Java, .NET, Ruby on Rails\nFrontend: Angular, React", requiredMode = RequiredMode.NOT_REQUIRED, description = "Candidate's curriculum")
  private String curriculum;

  @CreationTimestamp
  @Schema(example = "2023-11-14T19:39:26.732232")
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Schema(example = "2023-09-26T19:38:15.030000")
  private LocalDateTime updatedAt;
}
