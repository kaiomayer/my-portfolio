package com.backend.portfolio.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long String;

    @NotBlank
    @Size(min = 5, max = 64)
    private String username;

    @NotBlank
    private String password;

    @Size(max = 500)
    private String bio;

    public User(String username, String password, String bio){
        this.username = username;
        this.password = password;
        this.bio = bio;
    }
}
