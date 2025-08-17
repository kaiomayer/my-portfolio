package com.backend.portfolio.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "experiences")
@NoArgsConstructor
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 64)
    private String position;

    @NotBlank
    @Size(max = 64)
    private String company;

    @PastOrPresent
    @NotNull
    private LocalDate startDate;

    @PastOrPresent
    private LocalDate endDate;

    @NotNull
    @Size(max = 500)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Experience(String position, String company, LocalDate startDate, LocalDate endDate, String description, User user) {
        this.position = position;
        this.company = company;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.user = user;
    }
}
