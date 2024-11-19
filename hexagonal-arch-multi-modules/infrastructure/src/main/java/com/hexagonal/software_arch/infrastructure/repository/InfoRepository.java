package com.hexagonal.software_arch.infrastructure.repository;

import com.hexagonal.software_arch.domain.entity.MyInfo;
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

    public MyInfoDto addInformation(MyInfoDto myInfoDto) {
        MyInfo information = new MyInfo();
        information.setFullName(myInfoDto.fullName());
        information.setEmail(myInfoDto.email());
        information.setMobile(myInfoDto.mobile());
        MyInfo savedInfo = myInfoRepo.save(information);

        return new MyInfoDto(savedInfo.getFullName(), savedInfo.getMobile(), savedInfo.getEmail());
    }
}

