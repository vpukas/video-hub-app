package com.vpukas.backend.repositories;

import java.util.Optional;

import com.vpukas.backend.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vpukas.backend.entities.User;
import com.vpukas.backend.entities.VideoRate;
import com.vpukas.backend.entities.View;

@Repository
public interface VideoRateRepository extends JpaRepository<VideoRate, Long> {
    // @Query("SELECT vr from VideoRate vr where vr.viewer = :user and vr.view = :view")
    // Optional<VideoRate> findByViewAndUser(View view, User user);

    Optional<VideoRate> findVideoRateByVideoAndViewer(Video video, User user);

    Long countAllByVideoAndRateIsTrue(Video video);
}
