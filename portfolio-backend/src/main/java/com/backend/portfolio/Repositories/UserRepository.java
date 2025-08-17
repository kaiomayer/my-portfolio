package com.backend.portfolio.Repositories;

import com.backend.portfolio.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
