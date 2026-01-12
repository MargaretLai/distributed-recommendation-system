package com.example.recommendationservice.controller;

import java.util.List;
import java.util.UUID;

import com.example.recommendationservice.recommendation.UserRecommendation;
import com.example.recommendationservice.recommendation.UserRecommendationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRecommendationController {

    private final UserRecommendationRepository repository;

    public UserRecommendationController(UserRecommendationRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/recommendations/{userId}")
    public List<UserRecommendation> getRecommendations(
            @PathVariable UUID userId
    ) {
        return repository.findByKeyUserId(userId);
    }
}

