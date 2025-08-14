package com.backend.portfolio.dtos;

import jakarta.validation.constraints.*;

public record MailDTO(
        @NotBlank @Size(max = 64) String firstName,
        @NotBlank @Size(max = 64) String lastName,
        @NotNull String phone,
        @Email @Size(min = 16, max = 40) String email,
        @NotBlank @Size(max = 998) String subject,
        @NotBlank @Size(max = 998) String message
) {
}
