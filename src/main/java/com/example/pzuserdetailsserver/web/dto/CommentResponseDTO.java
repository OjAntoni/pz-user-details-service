package com.example.pzuserdetailsserver.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponseDTO {
    private UUID uuid;
    private LocalDateTime createdAt;
    private UUID authorId;
    private String content;
    private UUID articleId;

}
