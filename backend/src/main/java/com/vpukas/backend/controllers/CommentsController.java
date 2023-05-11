package com.vpukas.backend.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vpukas.backend.entities.User;
import com.vpukas.backend.requests.CreateCommentRequest;
import com.vpukas.backend.responses.CommentDTO;
import com.vpukas.backend.services.CommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/videos/{id}/comments")
@RequiredArgsConstructor
public class CommentsController {

    private final CommentService commentService;

    @GetMapping
    public ResponseEntity<List<CommentDTO>> getAllVideoComments(@PathVariable("id") Long id) {
        return ResponseEntity.ok(commentService.getAllVideoComments(id));
    }

    @PostMapping
    public void createComment(@PathVariable("id") Long id,
            @AuthenticationPrincipal User user,
            @RequestBody CreateCommentRequest commentRequest) {
        commentService.createComment(user, commentRequest, id);
    }
}
