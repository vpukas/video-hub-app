package com.vpukas.backend.controllers;

import java.io.IOException;
import java.util.List;

import com.vpukas.backend.services.PreviewPictureService;
import com.vpukas.backend.services.ViewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vpukas.backend.entities.User;
import com.vpukas.backend.requests.CreateVideoRequest;
import com.vpukas.backend.responses.VideoCardDTO;
import com.vpukas.backend.responses.VideoDataDTO;
import com.vpukas.backend.services.VideoDataService;
import com.vpukas.backend.services.VideoService;

import io.micrometer.core.ipc.http.HttpSender.Response;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/videos")
@RequiredArgsConstructor
public class VideoController {
    private final VideoService videoService;
    private final VideoDataService videoDataService;
    private final PreviewPictureService pictureService;

    @PostMapping()
    public ResponseEntity<String> saveVideo(@AuthenticationPrincipal User user,@RequestParam("video") MultipartFile video,  @RequestParam("preview") MultipartFile preview, @ModelAttribute() CreateVideoRequest createVideoRequest) throws IOException {
        videoService.saveVideo(video, preview, createVideoRequest, user);
        return ResponseEntity.ok("Video saved successfully.");
    }

//    @GetMapping("{name}")
//    @Transactional
//    public ResponseEntity<Resource> getVideoByName(@PathVariable("name") String name){
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .contentType(MediaType.APPLICATION_OCTET_STREAM)
//                .body(new ByteArrayResource(videoService.getVideoByName(name).getData()));
//    }

    @GetMapping("{id}")
    @Transactional
    public ResponseEntity<Resource> getVideoById(@PathVariable("id") Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new ByteArrayResource(videoService.getVideoById(id).getData()));
    }

    @GetMapping("{id}/data")
    public ResponseEntity<VideoDataDTO> getVideoData(@PathVariable("id") Long id) {
        return ResponseEntity.ok(videoDataService.getVideoData(id));
    }

    @GetMapping()
    public ResponseEntity<List<VideoCardDTO>> getRecommendedVideos(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(videoDataService.getRecommendedVideos(user));
    }

    @GetMapping("/history")
    public ResponseEntity<List<VideoCardDTO>> getWatchedVideos(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(videoDataService.getWatchedVideos(user));
    }

    @GetMapping("{previewId}/image")
    @Transactional
    public ResponseEntity<byte[]> getVideoPreviewById(@PathVariable("previewId") Long previewId) {
        byte[] preview = pictureService.getPreviewPicture(previewId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png")).body(preview);
    }

}
