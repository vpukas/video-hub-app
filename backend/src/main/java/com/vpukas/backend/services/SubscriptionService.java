package com.vpukas.backend.services;

import org.springframework.stereotype.Service;

import com.vpukas.backend.repositories.SubscriptionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
}
