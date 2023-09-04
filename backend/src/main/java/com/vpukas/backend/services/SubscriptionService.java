package com.vpukas.backend.services;

import com.vpukas.backend.entities.Subscription;
import com.vpukas.backend.entities.User;
import com.vpukas.backend.repositories.UserRepository;
import com.vpukas.backend.responses.FollowedChannelDTO;
import org.springframework.stereotype.Service;

import com.vpukas.backend.repositories.SubscriptionRepository;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;

    public Long countSubscribers(User user) {
        return subscriptionRepository.countAllBySubUser(user);
    }

    public Boolean isSubscribed(User user, Long channelId) {
        User channel = userRepository.findById(channelId).orElseThrow();
        if(subscriptionRepository.findByUserAndSubUser(user, channel).isPresent()) {
            return true;
        };
        return false;
    }

    public void subscribe(User user, Long channelId) {
        User channel = userRepository.findById(channelId).orElseThrow();
        subscriptionRepository.save(Subscription
                .builder()
                .user(user)
                .subUser(channel)
                .build());
    }

    public void unsubscribe(User user, Long channelId) {
        User channel = userRepository.findById(channelId).orElseThrow();
        Subscription subscription = subscriptionRepository.findByUserAndSubUser(user, channel).orElseThrow();
        subscriptionRepository.delete(subscription);
    }

    public List<FollowedChannelDTO> getSubscribedChannels(User user) {
        List<Subscription> subscriptionList = subscriptionRepository.findAllByUser(user);
        List<FollowedChannelDTO> followedChannelDTOList = new ArrayList<>();
        subscriptionList.forEach(subscription -> followedChannelDTOList
                .add(FollowedChannelDTO.builder()
                        .id(subscription.getSubUser().getId())
                        .username(subscription.getSubUser().getUsername())
                        .build()));
        return followedChannelDTOList;
    }
}
