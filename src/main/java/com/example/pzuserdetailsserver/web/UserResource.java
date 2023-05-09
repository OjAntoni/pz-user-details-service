package com.example.pzuserdetailsserver.web;

import com.example.pzuserdetailsserver.model.User;
import com.example.pzuserdetailsserver.service.UserService;
import com.example.pzuserdetailsserver.web.dto.PatchUserDto;
import com.example.pzuserdetailsserver.web.dto.UserRegistrationDTO;
import com.example.pzuserdetailsserver.web.mapper.UserMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserResource {
    private UserService userService;
    private UserMapper userMapper;
    private ObjectMapper objectMapper;

    @PostMapping
    @SneakyThrows
    public ResponseEntity<?> createNewUser(@Valid @RequestBody UserRegistrationDTO dto, BindingResult result){
        if (result.hasErrors()) {
            HashMap<String, String> map = new HashMap<>();
            result.getFieldErrors().forEach(e -> map.put(e.getField(), e.getDefaultMessage()));
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("location", userService.save(userMapper.toEntity(dto)).toString());
        return new ResponseEntity<>(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectNode), HttpStatus.OK);
    }

    @GetMapping("{uuid}")
    public ResponseEntity<?> getUserByUUID(@PathVariable UUID uuid){
        User byUUID = userService.getByUUID(uuid);
        if (byUUID!=null) {
            return new ResponseEntity<>(byUUID, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PatchMapping("{uuid}")
    public ResponseEntity<?> updateUser(@PathVariable UUID uuid,
                                        @RequestBody @Valid PatchUserDto dto,
                                        BindingResult result){
        if (result.hasErrors()) {
            HashMap<String, String> map = new HashMap<>();
            result.getFieldErrors().forEach(e -> map.put(e.getField(), e.getDefaultMessage()));
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }

        User byUUID = userService.getByUUID(uuid);
        if (byUUID!=null) {
            User user = userMapper.toEntity(dto);
            user.setId(uuid);
            userService.update(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("{uuid}")
    public ResponseEntity<?> deleteUser(@PathVariable UUID uuid){
        userService.delete(uuid);
        return new ResponseEntity<>(HttpStatus.GONE);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers(@RequestParam int page, @RequestParam int size){
        return new ResponseEntity<>(userService.getAll(page, size), HttpStatus.OK);
    }
}
