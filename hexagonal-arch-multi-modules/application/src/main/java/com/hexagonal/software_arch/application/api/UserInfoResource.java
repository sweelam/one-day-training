package com.hexagonal.software_arch.application.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexagonal.software_arch.application.dto.MyInfoDto;
import com.hexagonal.software_arch.application.service.InfoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("api/info")
public class UserInfoResource {
    private final InfoService infoService;


    public UserInfoResource(InfoService infoService) {
        this.infoService = infoService;
    }


    @GetMapping("/{info_id}")
    public ResponseEntity<MyInfoDto> getInfoById(@PathVariable("info_id") int infoId) {
        return ResponseEntity.ok(infoService.getUserInfo(infoId));
    }
    

}

