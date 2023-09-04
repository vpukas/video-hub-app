package com.vpukas.backend.controllers;

import com.vpukas.backend.entities.Video;
import com.vpukas.backend.repositories.VideoRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vpukas.backend.entities.User;
import com.vpukas.backend.services.ViewService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/videos/{id}/views")
@RequiredArgsConstructor
public class ViewController {
    
    private final ViewService viewService;
    private final VideoRepository videoRepository;

     @PostMapping("/watch")
     public void watchVideo(@AuthenticationPrincipal User user, @PathVariable("id") Long id) {
         Video video = videoRepository.findById(id).orElseThrow();
         viewService.watchVideo(user, video);
     }
}
