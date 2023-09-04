package com.vpukas.backend.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vpukas.backend.entities.User;
import com.vpukas.backend.entities.Video;
import com.vpukas.backend.entities.View;

@Repository
public interface ViewRepository extends JpaRepository<View, Long> {
    Long countViewsByVideo(Video video);

    Optional<View> findByVideoAndViewer(Video video, User user);

//    @Query("SELECT v FROM View v WHERE v.viewer = :viewer")
//    List<View> findAllVByViewer(@Param("viewer") User viewer);
    List<View> findViewsByViewer(@Param("viewer") User viewer);
}
