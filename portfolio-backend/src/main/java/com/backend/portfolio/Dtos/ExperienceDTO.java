package com.backend.portfolio.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record ExperienceDTO(
        Long id,
        @NotBlank @Size(max = 64) String position,
        @NotBlank @Size(max = 64) String company,
        @NotNull @PastOrPresent LocalDate startDate,
        @PastOrPresent LocalDate endDate,
        @NotBlank @Size(max = 500) String description
) {}