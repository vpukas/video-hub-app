package com.vpukas.backend.services;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import com.vpukas.backend.entities.User;
import com.vpukas.backend.entities.Video;
import com.vpukas.backend.entities.View;
import com.vpukas.backend.repositories.ViewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ViewService {
    // private final ViewRepository viewRepository;
    // private final VideoService videoService;
    // private final VideoRateService videoRateService;

    // public void watchVideo(User user, Long videoId) {
    //     Video video = videoService.getVideoById(videoId);
    //     Optional<View> viewOptional = viewRepository.findByUserAndVideo(user, video);
    //     if (viewOptional.isPresent()) {
    //         View view = viewOptional.get();
    //         view.setViewedAt(LocalDateTime.now());
    //         viewRepository.save(view);
    //     } else {
    //         videoRateService.initVideoRate(user,
    //                 viewRepository.save(View.builder()
    //                         .video(video)
    //                         .viewedAt(LocalDateTime.now())
    //                         .viewer(user)
    //                         .build()));
    //     }
    // }

    // public View getView(User user, Long videoId) {
    //     return viewRepository.findByUserAndVideo(user, videoService.getVideoById(videoId))
    //             .orElseThrow(() -> new RuntimeException("View not found"));
    // }
}
