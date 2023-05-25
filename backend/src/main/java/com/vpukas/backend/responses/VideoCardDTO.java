package com.vpukas.backend.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoCardDTO {
    private Long id;
    private Long views;
    private String title;
    // private byte[] image;
    private String channelName;
    private Long channelId;
}
