package com.vpukas.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vpukas.backend.entities.User;
import com.vpukas.backend.entities.VideoRate;
import com.vpukas.backend.entities.View;

@Repository
public interface VideoRateRepository extends JpaRepository<VideoRate, Long> {
    @Query("SELECT vr from video_rate vr where vr.viewer = :user and vr.view = :view")
    Optional<VideoRate> findByViewAndUser(View view, User user);
}
