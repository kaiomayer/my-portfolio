package com.backend.portfolio.Repositories;

import com.backend.portfolio.Models.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
