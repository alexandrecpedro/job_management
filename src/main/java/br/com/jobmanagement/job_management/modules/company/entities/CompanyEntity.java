package br.com.jobmanagement.job_management.modules.company.entities;

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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "company")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Schema(example = "ee98d7c2-78fa-546f-86f8-7cb6f4a24b46", description = "Company's ID")
  private UUID id;

  @Schema(example = "Java Jobs", description = "Company's name")
  private String name;

  @NotBlank(message = "The field [username] is mandatory!")
  @Pattern(regexp = "\\S+", message = "The [username] field must not contain spaces!")
  @Schema(example = "java_company", requiredMode = RequiredMode.REQUIRED, description = "Company's username")
  private String username;

  @Email(message = "The [email] field must be a valid e-mail!")
  @Schema(example = "java@company.com.br", requiredMode = RequiredMode.REQUIRED, description = "Company's e-mail")
  private String email;

  @Length(min = 10, max = 100, message = "The password must contain between (10) and (100) characters!")
  @Schema(example = "1234567890", minLength = 10, maxLength = 100, requiredMode = RequiredMode.REQUIRED, description = "Company's password")
  private String password;

  @Schema(example = "https://javajobs.com.br", description = "Company's website")
  private String website;

  @Schema(example = "Company responsible for Java job openings", description = "Company's description")
  private String description;

  @CreationTimestamp
  @Schema(example = "2023-11-14T19:39:26.732232")
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Schema(example = "2023-09-26T19:38:15.030000")
  private LocalDateTime updatedAt;
}
