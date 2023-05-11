package com.vpukas.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vpukas.backend.entities.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    
}
