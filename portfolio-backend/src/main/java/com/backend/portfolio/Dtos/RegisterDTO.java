package com.backend.portfolio.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterDTO(
        @NotBlank @Size(max = 64) String username,
        @Size(max = 128) String bio,
        @Size(max = 500) String description,
        @NotBlank String password
) {
}
