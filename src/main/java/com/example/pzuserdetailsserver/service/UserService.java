package com.example.pzuserdetailsserver.service;

import com.example.pzuserdetailsserver.model.User;
import com.example.pzuserdetailsserver.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public void save(User user){
        userRepository.save(user);
    }

    public void update(User user){
        if(userRepository.existsById(user.getId())){
            userRepository.save(user);
        }
    }

    public void delete(UUID id){
        userRepository.deleteById(id);
    }


}
