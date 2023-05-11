package com.vpukas.backend.services;

import org.springframework.stereotype.Service;

import com.vpukas.backend.entities.Video;
import com.vpukas.backend.repositories.VideoRepository;
import com.vpukas.backend.responses.VideoDataDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VideoDataService {
    private final VideoRepository videoRepository;

    public VideoDataDTO getVideoData(Long id) {

        Video video = videoRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Video not found"));
        VideoDataDTO videoData = VideoDataDTO.builder()
                .category(video.getCategory())
                .videoId(video.getId())
                .build();
        return videoData;
    }
}
