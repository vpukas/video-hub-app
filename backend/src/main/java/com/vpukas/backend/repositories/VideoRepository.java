package com.vpukas.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vpukas.backend.entities.User;
import com.vpukas.backend.entities.Video;
import com.vpukas.backend.responses.VideoCardDTO;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long>{
    Video findByName(String name);
    boolean existsByName(String name);
    @Query("SELECT new com.vpukas.backend.responses.VideoCardDTO(v.id, v.id, v.name, u.email, u.id) " +
       "FROM Video v " +
       "LEFT JOIN v.picture pp " +
       "LEFT JOIN v.user u")
List<VideoCardDTO> getRecommendedVideos(User user);

}
