package com.example.recommendationservice.recommendation;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("user_recommendation")
public class UserRecommendation {

    @PrimaryKey
    private UserRecommendationKey key;

    @Column("item_id")
    private UUID itemId;

    @Column("item_name")
    private String itemName;

    @Column("item_category")
    private String itemCategory;

    @Column("item_price")
    private BigDecimal itemPrice;

    @Column("item_picture_url")
    private String itemPictureUrl;

    public UserRecommendation() {}

    public UserRecommendationKey getKey() {
        return key;
    }

    public void setKey(UserRecommendationKey key) {
        this.key = key;
    }

    public UUID getItemId() {
        return itemId;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemPictureUrl() {
        return itemPictureUrl;
    }

    public void setItemPictureUrl(String itemPictureUrl) {
        this.itemPictureUrl = itemPictureUrl;
    }
}
