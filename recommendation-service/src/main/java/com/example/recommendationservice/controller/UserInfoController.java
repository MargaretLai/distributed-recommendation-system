package com.example.recommendationservice.controller;

import java.util.UUID;

import com.example.recommendationservice.user.UserInfo;
import com.example.recommendationservice.user.UserInfoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {

    private final UserInfoRepository repository;

    public UserInfoController(UserInfoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/user-info/{userId}")
    public UserInfo getUserInfo(@PathVariable UUID userId) {
        return repository.findById(userId).orElse(null);
    }
}

