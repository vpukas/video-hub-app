package com.vpukas.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vpukas.backend.entities.VideoRate;

@Repository
public interface VideoRateRepository extends JpaRepository<VideoRate, Long> {
    
}
