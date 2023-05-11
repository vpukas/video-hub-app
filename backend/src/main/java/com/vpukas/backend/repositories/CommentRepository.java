package com.vpukas.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vpukas.backend.entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    
}
