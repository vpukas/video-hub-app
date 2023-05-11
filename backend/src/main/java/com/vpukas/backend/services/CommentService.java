package com.vpukas.backend.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vpukas.backend.entities.Comment;
import com.vpukas.backend.entities.User;
import com.vpukas.backend.entities.Video;
import com.vpukas.backend.repositories.CommentRepository;
import com.vpukas.backend.requests.CreateCommentRequest;
import com.vpukas.backend.responses.CommentDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final VideoService videoService;

    public List<CommentDTO> getAllVideoComments(Long videoId) {
        Video video = videoService.getVideoById(videoId);
        List<Comment> comments = commentRepository.findAllByVideo(video);
        List<CommentDTO> commentDTOs = new ArrayList<>();
        for (Comment comment : comments) {
            commentDTOs.add(CommentDTO.builder()
                    .commentedAt(comment.getCommentedAt())
                    .userName(comment.getUser().getUsername())
                    .text(comment.getText())
                    .build());
        }
        return commentDTOs;
    }

    public void createComment(User user, CreateCommentRequest commentRequest, Long id) {
        Video video = videoService.getVideoById(id);
        commentRepository.save(Comment.builder()
                .commentedAt(LocalDateTime.now())
                .text(commentRequest.getText())
                .user(user)
                .video(video)
                .build());
    }
}
