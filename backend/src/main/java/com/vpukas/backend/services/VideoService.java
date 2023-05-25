package com.vpukas.backend.services;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vpukas.backend.entities.PreviewPicture;
import com.vpukas.backend.entities.User;
import com.vpukas.backend.entities.Video;
import com.vpukas.backend.exceptions.VideoAlreadyExistsException;
import com.vpukas.backend.repositories.VideoRepository;
import com.vpukas.backend.requests.CreateVideoRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VideoService {
    private final VideoRepository videoRepository;
    private final PreviewPictureService pictureService;

    public Video getVideoByName(String name) {
        if (!videoRepository.existsByName(name)) {
            throw new VideoAlreadyExistsException();
        }

        return videoRepository.findByName(name);
    }

    public Video getVideoById(Long id) {
        // if(!videoRepository.existsById(name)) {
        // throw new VideoAlreadyExistsException();
        // }

        Optional<Video> videoOpt = videoRepository.findById(id);

        return videoOpt.orElseThrow(() -> new RuntimeException("Video does not exist"));
    }

    public void saveVideo(MultipartFile video, MultipartFile preview, CreateVideoRequest createVideoRequest, User user)
            throws IOException {
        if (videoRepository.existsByName(createVideoRequest.getName())) {
            throw new VideoAlreadyExistsException();
        }
        PreviewPicture previewPicture = pictureService.savePreviewPricture(preview);
        Video newVideo = Video.builder()
                .createdAt(LocalDateTime.now())
                .data(video.getBytes())
                .name(createVideoRequest.getName())
                .user(user)
                .build();
        // newVideo.setCategory(createVideoRequest.getCategory());
        newVideo.setPicture(previewPicture);
        videoRepository.save(newVideo);
    }
}
