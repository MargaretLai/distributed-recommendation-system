package com.example.recommendationservice.user;

import java.util.UUID;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UserInfoRepository extends CassandraRepository<UserInfo, UUID> {
}
