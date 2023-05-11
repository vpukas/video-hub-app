package com.vpukas.backend.services;

import org.springframework.stereotype.Service;

import com.vpukas.backend.repositories.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
}
