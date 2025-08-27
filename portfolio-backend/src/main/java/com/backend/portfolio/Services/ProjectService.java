package com.backend.portfolio.Services;

import com.backend.portfolio.Models.Project;
import com.backend.portfolio.Repositories.ProjectRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public List<Project> listProjects(){
        return this.projectRepository.findAll();
    }

    public void save(Project project){
        projectRepository.save(project);
    }

    public Optional<Project> findById(Long id) { return projectRepository.findById(id); }

    public Project updateProject(){
        return new Project();
    }
}
