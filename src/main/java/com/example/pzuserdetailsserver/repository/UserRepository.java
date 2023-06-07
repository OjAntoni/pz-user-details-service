package com.example.pzuserdetailsserver.repository;

import com.example.pzuserdetailsserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsById(UUID id);
    boolean existsByUsernameAndEmail(String username, String email);
    User findByUsernameAndEmail(String username, String email);
}
