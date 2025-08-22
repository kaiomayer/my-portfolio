package com.backend.portfolio.Dtos;

import jakarta.validation.constraints.NotBlank;

public record TokenDTO(
        @NotBlank String jwt
) {
}
