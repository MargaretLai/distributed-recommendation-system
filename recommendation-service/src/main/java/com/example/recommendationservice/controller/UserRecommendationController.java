package com.example.recommendationservice.controller;

import java.util.List;
import java.util.UUID;

import com.example.recommendationservice.recommendation.UserRecommendation;
import com.example.recommendationservice.service.RecommendationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRecommendationController {

    private final RecommendationService recommendationService;

    public UserRecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/recommendations/{userId}")
    public List<UserRecommendation> getRecommendations(
            @PathVariable UUID userId
    ) {
        return recommendationService.getRecommendations(userId);
    }
}
