package com.example.pzuserdetailsserver.repository;

import com.example.pzuserdetailsserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsById(UUID id);
}
