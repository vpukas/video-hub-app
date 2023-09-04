package com.vpukas.backend.services;

import com.vpukas.backend.entities.Video;
import com.vpukas.backend.entities.View;
import org.springframework.stereotype.Service;

import com.vpukas.backend.entities.User;
import com.vpukas.backend.entities.VideoRate;
import com.vpukas.backend.repositories.VideoRateRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VideoRateService {
    private final VideoRateRepository videoRateRepository;
    private final ViewService viewService;

    public void initVideoRate(User user, Video video) {
        videoRateRepository.save(VideoRate.builder()
                .viewer(user)
                .video(video)
                .rate(false)
                .build());
    }

    public void like(User user, Video video) {
        VideoRate videoRate = videoRateRepository.findVideoRateByVideoAndViewer(video, user).orElseThrow();
        videoRate.setRate(true);
        videoRateRepository.save(videoRate);

    }

    public void dislike(User user, Video video) {
        VideoRate videoRate = videoRateRepository.findVideoRateByVideoAndViewer(video, user).orElseThrow();
        videoRate.setRate(false);
        videoRateRepository.save(videoRate);
    }

    public Long likesCount(Video video) {
        return videoRateRepository.countAllByVideoAndRateIsTrue(video);
    }

}
