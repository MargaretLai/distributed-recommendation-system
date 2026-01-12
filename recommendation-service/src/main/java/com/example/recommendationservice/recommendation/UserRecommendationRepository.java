package com.example.recommendationservice.recommendation;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UserRecommendationRepository
        extends CassandraRepository<UserRecommendation, UserRecommendationKey> {

    List<UserRecommendation> findByKeyUserId(UUID userId);
}

