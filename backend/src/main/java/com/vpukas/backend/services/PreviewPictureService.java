package com.vpukas.backend.services;

import org.springframework.stereotype.Service;

import com.vpukas.backend.repositories.PreviewPictureRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PreviewPictureService {
    private final PreviewPictureRepository pictureRepository;
}
