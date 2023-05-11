package com.vpukas.backend.entities;


import com.vpukas.backend.enums.LikeStatus;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VideoRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "viewer_id")
    private User viewer;

    @OneToOne
    @JoinColumn(name = "view_id")
    private View view;

    @Enumerated(EnumType.STRING)
    private LikeStatus status;

}
