package com.example.pzuserdetailsserver.config;

import com.example.pzuserdetailsserver.model.User;
import com.example.pzuserdetailsserver.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InsertingDefaultDeletedUserIntoDB implements CommandLineRunner {
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        if (!userRepository.existsByUsernameAndEmail("DELETED", "")) {
            userRepository.save(
                    User.builder()
                            .email("")
                            .username("DELETED")
                            .surname("DELETED")
                            .name("DELETED")
                            .build()
            );
        }
    }
}
