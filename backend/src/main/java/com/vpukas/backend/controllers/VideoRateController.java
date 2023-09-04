package com.vpukas.backend.controllers;

import com.vpukas.backend.entities.Video;
import com.vpukas.backend.entities.VideoRate;
import com.vpukas.backend.services.VideoService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vpukas.backend.entities.User;
import com.vpukas.backend.requests.ChangeVideoRateDTO;
import com.vpukas.backend.services.VideoRateService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/videos/{id}/rates")
@RequiredArgsConstructor
public class VideoRateController {
    private final VideoRateService videoRateService;
    private final VideoService videoService;

    // @PostMapping
    // public void changeVideoRate(@AuthenticationPrincipal User user,
    //         @PathVariable("id") Long id,
    //         @RequestBody ChangeVideoRateDTO changeVideoRateDTO) {
    //     videoRateService.changeVideoRate(user, id, changeVideoRateDTO);
    // }

    @PostMapping("/like")
    public void like(@AuthenticationPrincipal User user, @PathVariable("id") Long id) {
        videoRateService.like(user, videoService.getVideoById(id));
    }

    @PostMapping("/dislike")
    public void dislike(@AuthenticationPrincipal User user, @PathVariable("id") Long id) {
        videoRateService.dislike(user, videoService.getVideoById(id));
    }

}
