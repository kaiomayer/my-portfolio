package com.backend.portfolio.Dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserDTO(
        @NotBlank
        @Size(min = 5, max = 64)
        String username,
        @Size(max = 128)
        String bio,
        @Size(max = 500) String description
) {
}
