package com.vpukas.backend.repositories;

import com.vpukas.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vpukas.backend.entities.Subscription;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    Long countAllByUser(User user);
    Long countAllBySubUser(User subUser);

    List<Subscription> findAllByUser(User user);
    Optional<Subscription> findByUserAndSubUser(User user, User subUser);

}
