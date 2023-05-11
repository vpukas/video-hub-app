package com.vpukas.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vpukas.backend.entities.Comment;
import com.vpukas.backend.entities.Video;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("SELECT c from Comment c where c.video = :video")
    List<Comment> findAllByVideo(Video video);
}
