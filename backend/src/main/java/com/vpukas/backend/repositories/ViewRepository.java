package com.vpukas.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vpukas.backend.entities.User;
import com.vpukas.backend.entities.Video;
import com.vpukas.backend.entities.View;

@Repository
public interface ViewRepository extends JpaRepository<View, Long> {
    // @Query("SELECT v from view v where v.viewer = :user and v.video = :video")
    // Optional<View> findByUserAndVideo(User user, Video video);
}
