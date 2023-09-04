package com.vpukas.backend.entities;

import java.time.LocalDateTime;
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
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    //TODO change for AWS S3
    @Lob
    private byte[] data;

    private LocalDateTime createdAt;

    // @Enumerated(EnumType.STRING)
    // private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "picture_id")
    private PreviewPicture picture;

    public Video(String name, byte[] data) {
        this.name = name;
        this.data = data;
    }
}
