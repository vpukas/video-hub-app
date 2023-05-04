package com.vpukas.backend.services;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vpukas.backend.entities.Video;
import com.vpukas.backend.exceptions.VideoAlreadyExistsException;
import com.vpukas.backend.repositories.VideoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VideoService {
    private final VideoRepository videoRepository;

    public Video getVideo(String name) {
        if(!videoRepository.existsByName(name)) {
            throw new VideoAlreadyExistsException();
        }

        return videoRepository.findByName(name);
    }   

    public void saveVideo(MultipartFile file, String name) throws IOException {
        if(videoRepository.existsByName(name)){
                throw new VideoAlreadyExistsException();
        }
        Video newVid = new Video(name, file.getBytes());
        videoRepository.save(newVid);
    }
}
