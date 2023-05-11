package com.vpukas.backend.services;

import org.springframework.stereotype.Service;

import com.vpukas.backend.repositories.ViewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ViewService {
    private final ViewRepository viewRepository;    
}
