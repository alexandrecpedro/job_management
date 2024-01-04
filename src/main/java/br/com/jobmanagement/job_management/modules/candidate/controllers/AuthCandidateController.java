package br.com.jobmanagement.job_management.modules.candidate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jobmanagement.job_management.modules.candidate.dto.AuthCandidateRequestDTO;
import br.com.jobmanagement.job_management.modules.candidate.dto.AuthCandidateResponseDTO;
import br.com.jobmanagement.job_management.modules.candidate.useCases.AuthCandidateUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/candidate")
@Tag(name = "Auth", description = "Authentication")
public class AuthCandidateController {
  @Autowired
  private AuthCandidateUseCase authCandidateUseCase;

  @PostMapping("/auth")
  @Operation(summary = "Candidate authentication", description = "This function is responsible for authenticating a candidate")
  @ApiResponses({
      @ApiResponse(responseCode = "200", content = {
          @Content(schema = @Schema(implementation = AuthCandidateResponseDTO.class)) }),
      @ApiResponse(responseCode = "400", description = "Unauthorized!")
  })
  public ResponseEntity<Object> auth(@RequestBody AuthCandidateRequestDTO authCandidateRequestDTO) {
    try {
      var token = this.authCandidateUseCase.execute(authCandidateRequestDTO);

      return ResponseEntity.ok().body(token);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }
  }
}
