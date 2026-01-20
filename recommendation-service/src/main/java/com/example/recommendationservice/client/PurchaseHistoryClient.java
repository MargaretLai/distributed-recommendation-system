package com.example.recommendationservice.client;

import java.util.UUID;

import com.example.recommendationservice.dto.PurchaseHistoryResponse;

public interface PurchaseHistoryClient {

    PurchaseHistoryResponse getPurchaseHistory(UUID userId);
}
