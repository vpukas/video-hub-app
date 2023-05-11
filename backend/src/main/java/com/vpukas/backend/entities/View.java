package com.vpukas.backend.entities;

import java.time.*;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class View {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "viewer_id")
    private User viewer;
    @ManyToOne
    @JoinColumn(name = "video_id")
    private Video video;

    private LocalDateTime viewedAt;
}
