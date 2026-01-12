package com.example.recommendationservice.recommendation;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public class UserRecommendationKey implements Serializable {

    @PrimaryKeyColumn(
            name = "user_id",
            type = PrimaryKeyType.PARTITIONED
    )
    private UUID userId;

    @PrimaryKeyColumn(
            name = "item_rank",
            type = PrimaryKeyType.CLUSTERED,
            ordinal = 0
    )
    private Integer itemRank;

    public UserRecommendationKey() {}

    public UserRecommendationKey(UUID userId, Integer itemRank) {
        this.userId = userId;
        this.itemRank = itemRank;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Integer getItemRank() {
        return itemRank;
    }

    public void setItemRank(Integer itemRank) {
        this.itemRank = itemRank;
    }
}
