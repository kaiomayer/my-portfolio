package com.backend.portfolio.Repositories;

import com.backend.portfolio.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, String> {
    UserDetails findByUsername(String username);
}
