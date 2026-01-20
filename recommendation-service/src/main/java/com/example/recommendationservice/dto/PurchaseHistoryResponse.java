package com.example.recommendationservice.dto;

import java.util.List;
import java.util.UUID;

public class PurchaseHistoryResponse {

    private UUID userId;
    private List<UUID> purchasedItemIds;

    public PurchaseHistoryResponse() {}

    public PurchaseHistoryResponse(UUID userId, List<UUID> purchasedItemIds) {
        this.userId = userId;
        this.purchasedItemIds = purchasedItemIds;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public List<UUID> getPurchasedItemIds() {
        return purchasedItemIds;
    }

    public void setPurchasedItemIds(List<UUID> purchasedItemIds) {
        this.purchasedItemIds = purchasedItemIds;
    }
}
