package com.backend.portfolio.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

public record LoginDTO (
    @Size(min = 5, max = 64) String username,
    @NotBlank String password
){

}

