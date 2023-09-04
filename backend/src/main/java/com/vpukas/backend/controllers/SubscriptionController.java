package com.vpukas.backend.controllers;

import com.vpukas.backend.entities.Subscription;
import com.vpukas.backend.entities.User;
import com.vpukas.backend.responses.FollowedChannelDTO;
import com.vpukas.backend.services.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @GetMapping("/{id}")
    public ResponseEntity<Boolean>isSubscribed(@PathVariable("id") Long id, @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(subscriptionService.isSubscribed(user, id));
    }

    @PostMapping("/subscribe/{id}")
    public void subscribe(@PathVariable("id") Long id, @AuthenticationPrincipal User user) {
        subscriptionService.subscribe(user, id);
    }

    @PostMapping("/unsubscribe/{id}")
    public void unsubscribe(@PathVariable("id") Long id, @AuthenticationPrincipal User user) {
        subscriptionService.unsubscribe(user, id);
    }

    @GetMapping()
    public ResponseEntity<List<FollowedChannelDTO>> getSubscribedChannels(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(subscriptionService.getSubscribedChannels(user));
    }
}
