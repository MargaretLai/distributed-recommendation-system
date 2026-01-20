package com.example.recommendationservice.service;

import java.util.List;
import java.util.UUID;

import com.example.recommendationservice.client.PurchaseHistoryClient;
import com.example.recommendationservice.dto.PurchaseHistoryResponse;
import com.example.recommendationservice.recommendation.UserRecommendation;
import com.example.recommendationservice.recommendation.UserRecommendationRepository;
import org.springframework.stereotype.Service;

@Service
public class RecommendationService {

    private final UserRecommendationRepository recommendationRepository;
    private final PurchaseHistoryClient purchaseHistoryClient;

    public RecommendationService(UserRecommendationRepository recommendationRepository, PurchaseHistoryClient purchaseHistoryClient) {
        this.recommendationRepository = recommendationRepository;
        this.purchaseHistoryClient = purchaseHistoryClient;
    }

    public List<UserRecommendation> getRecommendations(UUID userId) {

        // Fetch candidate recommendations
        List<UserRecommendation> recommendations =
                recommendationRepository.findByKeyUserId(userId);

        try {
            // Fetch purchase history
            PurchaseHistoryResponse purchaseHistory =
                    purchaseHistoryClient.getPurchaseHistory(userId);

            if (purchaseHistory == null ||
                    purchaseHistory.getPurchasedItemIds() == null ||
                    purchaseHistory.getPurchasedItemIds().isEmpty()) {

                return recommendations;
            }

            // Filter out purchased items
            return recommendations.stream()
                    .filter(rec ->
                            !purchaseHistory.getPurchasedItemIds()
                                    .contains(rec.getItemId()))
                    .toList();

        } catch (Exception ex) {

            // Fallback: return unfiltered recommendations
            System.out.println(
                    "Purchase history service unavailable for user " + userId +
                            ". Returning unfiltered recommendations."
            );

            return recommendations;
        }
    }

}
