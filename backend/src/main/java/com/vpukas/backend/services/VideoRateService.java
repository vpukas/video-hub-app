package com.vpukas.backend.services;

import org.springframework.stereotype.Service;

import com.vpukas.backend.entities.User;
import com.vpukas.backend.entities.VideoRate;
import com.vpukas.backend.entities.View;
import com.vpukas.backend.enums.LikeStatus;
import com.vpukas.backend.repositories.VideoRateRepository;
import com.vpukas.backend.requests.ChangeVideoRateDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VideoRateService {
    private final VideoRateRepository videoRateRepository;
    private final ViewService viewService;

    public VideoRate initVideoRate(User user, View view) {
        return videoRateRepository.save(VideoRate.builder()
                .view(view)
                .viewer(user)
                .status(LikeStatus.NoStatus)
                .build());
    }

    // public void changeVideoRate(User user, Long videoId, ChangeVideoRateDTO changeVideoRateDTO) {
    //     View view = viewService.getView(user, videoId);
    //     // VideoRate videoRate = this.getVideoRate(view, user);
    //     videoRate.setStatus(changeVideoRateDTO.getLikeStatus());
    //     videoRateRepository.save(videoRate);

    // }

    // public VideoRate getVideoRate(View view, User user) {
    //     // return videoRateRepository.findByViewAndUser(view, user)
    //     //         .orElseThrow(() -> new RuntimeException("Video rate not found"));
    // }
}
