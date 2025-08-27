package com.backend.portfolio.Controllers;

import com.backend.portfolio.Dtos.ProjectDTO;
import com.backend.portfolio.Exceptions.ProjectNotFoundException;
import com.backend.portfolio.Exceptions.UserNotFoundException;
import com.backend.portfolio.Models.Project;
import com.backend.portfolio.Models.User;
import com.backend.portfolio.Repositories.ProjectRepository;
import com.backend.portfolio.Services.ProjectService;
import com.backend.portfolio.Services.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final UserService userService;
    private final ProjectService projectService;
    private final ProjectRepository projectRepository;

    @GetMapping
    public ResponseEntity<List<Project>> listProjects(){
        List<Project> projects = this.projectService.listProjects();
        return ResponseEntity.ok(projects);
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@Valid @RequestBody ProjectDTO project){
        String username = userService.getAuthenticatedUserId();
        User user = (User) userService.findByUsername(username);

        if (user == null) {
            throw new UserNotFoundException("Usuário autenticado não encontrado.");
        }

        Project newProject = new Project(project.title(), project.startDate(), project.description(),
                                        project.url(), user);

        projectService.save(newProject);
        return ResponseEntity.ok(newProject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProject(@PathVariable Long id){
        if (projectService.findById(id).isEmpty()) {
            throw new ProjectNotFoundException("Projeto não encontrado.");
        }
        projectService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @Valid @RequestBody ProjectDTO projectDTO) {
        if (projectService.findById(id).isEmpty()) {
            throw new ProjectNotFoundException("Projeto não encontrado.");
        }
        Project project = projectService.findById(id).get();

        project.setDescription(projectDTO.description());
        project.setUrl(projectDTO.url());
        project.setStartDate(projectDTO.startDate());
        project.setTitle(projectDTO.title());

        projectService.save(project);
        return ResponseEntity.ok(project);
    }
}
