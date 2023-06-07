package com.example.pzuserdetailsserver.web.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@NoArgsConstructor
public class TopicResponseDTO {
    private UUID id;
    private UUID author;
    private String title;
    private String description;
}
