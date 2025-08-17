package com.backend.portfolio.Controllers;

import com.backend.portfolio.Services.ExperienceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/experiences")
@AllArgsConstructor
public class ExperienceController {

    private final ExperienceService experienceService;
}
