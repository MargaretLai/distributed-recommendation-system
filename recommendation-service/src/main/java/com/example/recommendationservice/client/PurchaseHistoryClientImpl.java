package com.example.recommendationservice.client;

import java.util.UUID;

import com.example.recommendationservice.dto.PurchaseHistoryResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PurchaseHistoryClientImpl implements PurchaseHistoryClient {

    private final RestTemplate restTemplate;

    // Hardcoded internal service URL (owned by another team)
    private static final String PURCHASE_HISTORY_URL =
            "http://purchase-history-service/api/purchases/{userId}";

    public PurchaseHistoryClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public PurchaseHistoryResponse getPurchaseHistory(UUID userId) {

        // Real HTTP call (not tested, but realistic)
        return restTemplate.getForObject(
                PURCHASE_HISTORY_URL,
                PurchaseHistoryResponse.class,
                userId
        );
    }
}
