package com.backend.portfolio.Repositories;

import com.backend.portfolio.Models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
