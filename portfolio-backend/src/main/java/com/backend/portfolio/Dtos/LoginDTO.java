package com.backend.portfolio.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginDTO (
    @NotBlank
    @Size(min = 5, max = 64) String username,
    @NotBlank String password
){

}

