package com.backend.portfolio.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginDTO {
    @NotBlank
    @Size(min = 5, max = 64)
    private String username;

    @NotBlank
    private String password;

    public LoginDTO() {}
}

