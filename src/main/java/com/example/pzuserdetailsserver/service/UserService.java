package com.example.pzuserdetailsserver.service;

import com.example.pzuserdetailsserver.model.User;
import com.example.pzuserdetailsserver.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public UUID save(User user){
        return userRepository.save(user).getId();
    }

    public void update(User user){
        if(userRepository.existsById(user.getId())){
            if (user.getWorkPlace() != null){
                User byId = userRepository.findById(user.getId()).get();
                if (byId.getWorkPlace()!=null) {
                    user.getWorkPlace().setId(byId.getWorkPlace().getId());
                }
            }
            userRepository.save(user);
        }
    }

    public void delete(UUID id){
        userRepository.deleteById(id);
    }

    public User getByUUID(UUID uuid){
        return userRepository.findById(uuid).orElse(null);
    }

    public List<User> getAll(int page, int perPage){
        return userRepository.findAll(PageRequest.of(Math.max(page, 0), Math.max(perPage, 1))).getContent();
    }
}
