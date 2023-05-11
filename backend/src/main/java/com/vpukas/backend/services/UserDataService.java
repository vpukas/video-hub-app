package com.vpukas.backend.services;

import org.springframework.stereotype.Service;

import com.vpukas.backend.repositories.UserDataRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDataService {
    private final UserDataRepository userDataRepository;
}
