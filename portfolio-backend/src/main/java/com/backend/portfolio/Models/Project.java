package com.backend.portfolio.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "projects")
@Getter
@Setter
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private LocalDate startDate;

    private String description;

    private String url;

    public Project(String title, LocalDate startDate, String description, String url) {
        this.title = title;
        this.startDate = startDate;
        this.description = description;
        this.url = url;
    }

}
