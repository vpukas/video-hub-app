package com.vpukas.backend.controllers;

import com.vpukas.backend.entities.User;
import com.vpukas.backend.repositories.UserRepository;
import com.vpukas.backend.responses.ChannelDTO;
import com.vpukas.backend.responses.VideoCardDTO;
import com.vpukas.backend.services.UserDataService;
import com.vpukas.backend.services.VideoDataService;
import com.vpukas.backend.services.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/channels")
@RequiredArgsConstructor
public class ChannelsController {

    private final VideoDataService videoDataService;
    private final UserRepository userRepository;
    private final UserDataService userDataService;


    @GetMapping("/{channelId}/videos")
    public ResponseEntity<List<VideoCardDTO>> getChannelVideos(@PathVariable Long channelId) {
        User user = userRepository.findById(channelId).orElseThrow();
        return ResponseEntity.ok(videoDataService.getChannelVideos(user));
    }


    @GetMapping("/owner/videos")
    public ResponseEntity<List<VideoCardDTO>> getChannelVideos(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(videoDataService.getChannelVideos(user));
    }

    @GetMapping("/{channelId}")
    public ResponseEntity<ChannelDTO> getChannelData(@PathVariable Long channelId) {
        User user = userRepository.findById(channelId).orElseThrow();
        return ResponseEntity.ok(userDataService.getChannelData(user));
    }
}
