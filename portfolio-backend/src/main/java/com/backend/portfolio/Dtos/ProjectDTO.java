package com.backend.portfolio.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record ProjectDTO(
        Long id,
        @NotBlank @Size(max = 100) String title,
        @NotNull LocalDate startDate,
        @NotBlank @Size(max = 1000) String description,
        @NotBlank String url
) {}