package com.backend.portfolio.Services;

import com.backend.portfolio.Dtos.ExperienceDTO;
import com.backend.portfolio.Exceptions.UserNotFoundException;
import com.backend.portfolio.Models.Experience;
import com.backend.portfolio.Models.User;
import com.backend.portfolio.Repositories.ExperienceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExperienceService {
    private final ExperienceRepository experienceRepository;
    private final UserService userService;

    public List<Experience> findAll() {
        return experienceRepository.findAll();
    }

    public Optional<Experience> findById(Long id) {
        return experienceRepository.findById(id);
    }

    public Experience create(ExperienceDTO experienceDTO) {
        String username = userService.getAuthenticatedUserId();
        User user = (User) userService.findByUsername(username);

        if (user == null) {
            throw new UserNotFoundException("Usuário autenticado não encontrado.");
        }

        Experience newExperience = new Experience(
                experienceDTO.position(),
                experienceDTO.company(),
                experienceDTO.startDate(),
                experienceDTO.endDate(),
                experienceDTO.description(),
                user
        );
        return experienceRepository.save(newExperience);
    }

    public Experience update(Long id, ExperienceDTO experienceDTO) {
        Experience experience = experienceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Experiência não encontrada!"));

        experience.setPosition(experienceDTO.position());
        experience.setCompany(experienceDTO.company());
        experience.setStartDate(experienceDTO.startDate());
        experience.setEndDate(experienceDTO.endDate());
        experience.setDescription(experienceDTO.description());

        return experienceRepository.save(experience);
    }

    public void delete(Long id) {
        if (!experienceRepository.existsById(id)) {
            throw new EntityNotFoundException("Experiência não encontrada!");
        }
        experienceRepository.deleteById(id);
    }
}
