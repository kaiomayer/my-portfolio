package com.backend.portfolio.Controllers;

import com.backend.portfolio.Dtos.ExperienceDTO;
import com.backend.portfolio.Models.Experience;
import com.backend.portfolio.Services.ExperienceService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/experiences")
@RequiredArgsConstructor
public class ExperienceController {
    private final ExperienceService experienceService;


    @GetMapping
    public ResponseEntity<List<Experience>> listAllExperiences() {
        List<Experience> experiences = experienceService.findAll();
        return ResponseEntity.ok(experiences);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Experience> getExperienceById(@PathVariable Long id) {
        return experienceService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Experience> createExperience(@Valid @RequestBody ExperienceDTO experienceDTO) {
        Experience createdExperience = experienceService.create(experienceDTO);
        return new ResponseEntity<>(createdExperience, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Experience> updateExperience(@PathVariable Long id, @Valid @RequestBody ExperienceDTO experienceDTO) {
        try {
            Experience updatedExperience = experienceService.update(id, experienceDTO);
            return ResponseEntity.ok(updatedExperience);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExperience(@PathVariable Long id) {
        try {
            experienceService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
