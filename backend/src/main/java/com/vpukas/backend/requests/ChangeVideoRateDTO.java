package com.vpukas.backend.requests;

import com.vpukas.backend.enums.LikeStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChangeVideoRateDTO {
    private LikeStatus likeStatus;
}
