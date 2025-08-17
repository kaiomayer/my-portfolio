package com.backend.portfolio.Controllers;

import com.backend.portfolio.Services.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/projects")
@AllArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
}
