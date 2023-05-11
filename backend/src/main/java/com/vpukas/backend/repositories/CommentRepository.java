package com.vpukas.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vpukas.backend.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    
}
