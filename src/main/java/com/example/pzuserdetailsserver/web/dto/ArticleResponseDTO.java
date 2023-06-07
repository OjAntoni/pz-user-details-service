package com.example.pzuserdetailsserver.web.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleResponseDTO {
    private UUID id;
    private UUID author;

    private TopicResponseDTO topic;
    private String title;

    private List<String> tags;
    private LocalDateTime createdAt;
    private String content;

    private List<URL> images;
}
