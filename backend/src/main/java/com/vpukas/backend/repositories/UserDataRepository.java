package com.vpukas.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vpukas.backend.entities.UserData;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Long> {
    
}
