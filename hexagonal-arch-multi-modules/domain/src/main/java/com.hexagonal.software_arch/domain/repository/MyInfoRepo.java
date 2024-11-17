package com.hexagonal.software_arch.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexagonal.software_arch.domain.entity.MyInfo;

public interface MyInfoRepo extends JpaRepository<MyInfo, Integer> {
    
}
