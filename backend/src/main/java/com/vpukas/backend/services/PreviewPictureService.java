package com.vpukas.backend.services;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vpukas.backend.entities.PreviewPicture;
import com.vpukas.backend.repositories.PreviewPictureRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PreviewPictureService {
    private final PreviewPictureRepository pictureRepository;

    public PreviewPicture savePreviewPricture(MultipartFile preview) throws IOException {
        return pictureRepository.save(PreviewPicture.builder()
                .data(preview.getBytes())
                .build());
    }
}
