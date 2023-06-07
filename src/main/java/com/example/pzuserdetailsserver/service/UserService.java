package com.example.pzuserdetailsserver.service;

import com.example.pzuserdetailsserver.model.User;
import com.example.pzuserdetailsserver.repository.UserRepository;
import com.example.pzuserdetailsserver.web.dto.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private UserActivitiesFeignClient userActivitiesFeignClient;
    private ArticleServiceFeignClient articleServiceFeignClient;

    public UUID save(User user) {
        return userRepository.save(user).getId();
    }

    public void update(User user) {
        if (userRepository.existsById(user.getId())) {
            if (user.getWorkPlace() != null) {
                User byId = userRepository.findById(user.getId()).get();
                if (byId.getWorkPlace() != null) {
                    user.getWorkPlace().setId(byId.getWorkPlace().getId());
                }
            }
            userRepository.save(user);
        }
    }

    public void delete(UUID id) {
        List<CommentResponseDTO> comments = userActivitiesFeignClient.getAllCommentsForUser(id);
        User def = getDefaultDeletedUser();
        comments.forEach(c -> {
            c.setAuthorId(def.getId());
            userActivitiesFeignClient.updateComment(c.getUuid(),
                    new CommentRequestDTO(c.getAuthorId(), c.getContent(), c.getArticleId()));
        });

        List<TopicResponseDTO> topics = articleServiceFeignClient.getAllTopicsForUser(id);
        topics.forEach(t -> {
            t.setAuthor(def.getId());
            articleServiceFeignClient.updateTopic(t.getId(),
                    TopicRequestDto.builder()
                            .author(def.getId())
                            .title(t.getTitle())
                            .description(t.getDescription())
                            .build());
        });
        userRepository.deleteById(id);

        List<ArticleResponseDTO> articles = articleServiceFeignClient.getAllArticlesForUser(id);
        articles.forEach(a -> {
            articleServiceFeignClient.updateArticle(a.getId(),
                    ArticleResponseDTO.builder()
                            .author(def.getId())
                            .title(a.getTitle())
                            .tags(a.getTags())
                            .content(a.getContent())
                            .images(a.getImages())
                            .createdAt(a.getCreatedAt())
                            .topic(a.getTopic())
                            .build()
                    );
        });

    }

    public User getByUUID(UUID uuid) {
        return userRepository.findById(uuid).orElse(null);
    }

    public List<User> getAll(int page, int perPage) {
        return userRepository.findAll(PageRequest.of(Math.max(page, 0), Math.max(perPage, 1))).getContent();
    }

    public User getDefaultDeletedUser() {
        return userRepository.findByUsernameAndEmail("DELETED", "");
    }
}
