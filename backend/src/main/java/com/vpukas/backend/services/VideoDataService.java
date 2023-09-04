package com.vpukas.backend.services;

import java.util.ArrayList;
import java.util.List;

import com.vpukas.backend.entities.View;
import com.vpukas.backend.repositories.ViewRepository;
import org.springframework.stereotype.Service;

import com.vpukas.backend.entities.User;
import com.vpukas.backend.entities.Video;
import com.vpukas.backend.repositories.VideoRepository;
import com.vpukas.backend.responses.VideoCardDTO;
import com.vpukas.backend.responses.VideoDataDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VideoDataService {
    private final VideoRepository videoRepository;
    private final ViewService viewService;
    private final VideoRateService videoRateService;
    private final ViewRepository viewRepository;

    public VideoDataDTO getVideoData(Long id) {

        Video video = videoRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Video not found"));
        Long viewCount = viewService.countViews(video);

        return VideoDataDTO.builder()
                .views(viewCount)
                .channel(video.getUser().getEmail())
                .channelId(video.getUser().getId())
                .likes(videoRateService.likesCount(video))
                .title(video.getName())
                .videoId(video.getId())
                .build();
    }

    public List<VideoCardDTO> getRecommendedVideos(User user) {
        List<VideoCardDTO> cardDTOS = videoRepository.getRecommendedVideos(user);
        cardDTOS.forEach(videoCardDTO -> videoCardDTO.setViews(viewService.countViews(videoRepository.findById(videoCardDTO.getId()).orElseThrow())));
        return cardDTOS;
    }

    public List<VideoCardDTO> getChannelVideos(User user) {
        List<VideoCardDTO> cardDTOS = videoRepository.getChannelVideos(user);
        cardDTOS.forEach(videoCardDTO -> videoCardDTO.setViews(viewService.countViews(videoRepository.findById(videoCardDTO.getId()).orElseThrow())));
        return cardDTOS;
    }

    public List<VideoCardDTO> getWatchedVideos(User user) {
        List<View> viewList = viewRepository.findViewsByViewer(user);
        List<VideoCardDTO> videoCardDTOList = new ArrayList<>();
//        viewList.forEach(view -> videoCardDTOList
//                .add(VideoCardDTO
//                        .builder()
//                        .views(viewService
//                                .countViews(view.getVideo()))
//                        .title(view.getVideo().getName())
//                        .id(view.getVideo().getId())
//                        .channelId(view.getVideo().getUser().getId())
//                        .channelName(view.getVideo().getUser().getUsername())
//                        .build()));
        return videoCardDTOList;
    }
}
