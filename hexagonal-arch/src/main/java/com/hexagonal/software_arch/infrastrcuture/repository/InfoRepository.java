package com.hexagonal.software_arch.infrastrcuture.repository;

import org.springframework.stereotype.Repository;
import com.hexagonal.software_arch.application.dto.MyInfoDto;
import com.hexagonal.software_arch.domain.repository.MyInfoRepo;

@Repository
public class InfoRepository {
    private final MyInfoRepo myInfoRepo;

    public InfoRepository(MyInfoRepo myInfoRepo) {
        this.myInfoRepo = myInfoRepo;
    }

    public MyInfoDto getInformationById(int id) {
        return myInfoRepo.findById(id)
            .map(m -> new MyInfoDto(m.getFullName(), m.getMobile(), m.getEmail()))
            .orElseThrow(() -> new RuntimeException("no data found"));
    }
    
}

