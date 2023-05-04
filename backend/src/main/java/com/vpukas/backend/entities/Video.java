package com.vpukas.backend.entities;

import com.vpukas.backend.enums.Category;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    //TODO change for AWS S3
    @Lob
    private byte[] data;

    private Long likes = 0L;

    private Long dislikes = 0L;

    private Long views = 0L;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Video(String name, byte[] data) {
        this.name = name;
        this.data = data;
    }
}
