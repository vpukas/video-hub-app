package com.vpukas.backend.responses;

import com.vpukas.backend.enums.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoDataDTO {
    private Long videoId;
    private Long likes;
    private Long dislikes;
    private Long comments;
    private Long views;
    private Category category;
}
