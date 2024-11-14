package com.hexagonal.software_arch.application.service;

import org.springframework.stereotype.Service;

import com.hexagonal.software_arch.application.dto.MyInfoDto;
import com.hexagonal.software_arch.infrastrcuture.repository.InfoRepository;

@Service
public class InfoService {
    private final InfoRepository infoRepository;

    public InfoService(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    public MyInfoDto getUserInfo(int id) {
        return infoRepository.getInformationById(id);
    }
}
