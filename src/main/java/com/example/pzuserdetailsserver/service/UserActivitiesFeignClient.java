package com.example.pzuserdetailsserver.service;

import com.example.pzuserdetailsserver.web.dto.CommentRequestDTO;
import com.example.pzuserdetailsserver.web.dto.CommentResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "user-client", url = "${user-client.url}")
public interface UserActivitiesFeignClient {
    @GetMapping("/api/v1/comment/all")
    List<CommentResponseDTO> getAllCommentsForUser(@RequestParam UUID userId);

    @PutMapping("/api/v1/comment/{id}")
    CommentResponseDTO updateComment(@PathVariable UUID id, @RequestBody CommentRequestDTO dto);

}
