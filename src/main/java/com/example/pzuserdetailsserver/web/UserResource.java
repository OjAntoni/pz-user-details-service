package com.example.pzuserdetailsserver.web;

import com.example.pzuserdetailsserver.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserResource {
    private UserService userService;

    @PostMapping()
    public ResponseEntity<?> createNewUser(){
        return null;
    }
}
