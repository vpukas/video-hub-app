package com.vpukas.backend.services;

import com.vpukas.backend.entities.User;
import com.vpukas.backend.responses.ChannelDTO;
import org.springframework.stereotype.Service;

import com.vpukas.backend.repositories.UserDataRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDataService {
    private final UserDataRepository userDataRepository;
    private final SubscriptionService subscriptionService;

    public ChannelDTO getChannelData(User user) {
        return ChannelDTO
                .builder()
                .username(user.getUsername())
                .subscribers(subscriptionService.countSubscribers(user))
                .build();
    }


}
