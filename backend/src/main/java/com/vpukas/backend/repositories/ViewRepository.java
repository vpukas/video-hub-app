package com.vpukas.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vpukas.backend.entities.View;

public interface ViewRepository extends JpaRepository<View, Long>{
    
}
