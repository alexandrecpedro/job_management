package br.com.jobmanagement.job_management.modules.company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jobmanagement.job_management.modules.company.dto.AuthCompanyRequestDTO;
import br.com.jobmanagement.job_management.modules.company.dto.AuthCompanyResponseDTO;
import br.com.jobmanagement.job_management.modules.company.useCases.AuthCompanyUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/company")
@Tag(name = "Auth", description = "Authentication")
public class AuthCompanyController {
  @Autowired
  private AuthCompanyUseCase authCompanyUseCase;

  @PostMapping("/auth")
  @Operation(summary = "Company authentication", description = "This function is responsible for authenticating a company")
  @ApiResponses({
      @ApiResponse(responseCode = "200", content = {
          @Content(schema = @Schema(implementation = AuthCompanyResponseDTO.class)) }),
      @ApiResponse(responseCode = "400", description = "Unauthorized!")
  })
  public ResponseEntity<Object> create(@RequestBody AuthCompanyRequestDTO authCompanyRequestDTO) {
    try {
      var result = authCompanyUseCase.execute(authCompanyRequestDTO);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }
  }
}
