package com.example.pzuserdetailsserver.service;


import com.example.pzuserdetailsserver.web.dto.ArticleRequestDTO;
import com.example.pzuserdetailsserver.web.dto.ArticleResponseDTO;
import com.example.pzuserdetailsserver.web.dto.TopicRequestDto;
import com.example.pzuserdetailsserver.web.dto.TopicResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "article-service", url = "${article-service.url}")
public interface ArticleServiceFeignClient {

    @GetMapping("/api/v1/article/all/{id}")
    List<ArticleResponseDTO> getAllArticlesForUser(@PathVariable UUID id);

    @GetMapping("/api/v1/topic/all/{id}")
    List<TopicResponseDTO> getAllTopicsForUser(@PathVariable UUID id);

    @PutMapping("/api/v1/topic/{id}")
    TopicResponseDTO updateTopic(@PathVariable UUID id, @RequestBody TopicRequestDto dto);

    @PutMapping("/api/v1/article/{id}")
    ArticleResponseDTO updateArticle(@PathVariable UUID id, @RequestBody ArticleResponseDTO dto);
}
