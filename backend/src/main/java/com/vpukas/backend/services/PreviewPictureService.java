package com.vpukas.backend.services;

import java.io.IOException;
import java.util.Optional;

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

    public byte[] getPreviewPicture(Long id) {
        Optional<PreviewPicture> previewPictureOptional = pictureRepository.findById(id);

        return previewPictureOptional.orElseThrow().getData();
    }
}
