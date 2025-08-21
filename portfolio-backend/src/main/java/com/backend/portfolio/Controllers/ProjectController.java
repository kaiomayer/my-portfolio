package com.backend.portfolio.Controllers;

import com.backend.portfolio.Dtos.PostProject;
import com.backend.portfolio.Models.Project;
import com.backend.portfolio.Services.ProjectService;
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

    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> listProjects(){
        List<Project> projects = this.projectService.listProjects();
        return ResponseEntity.ok(projects);
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@Valid @RequestBody PostProject project){
        Project p = new Project();
        return ResponseEntity.created(null).build();
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteProject(){

        return ResponseEntity.noContent().build();
    }
}
