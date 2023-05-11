package com.vpukas.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vpukas.backend.entities.View;

@Repository
public interface ViewRepository extends JpaRepository<View, Long>{
    
}
