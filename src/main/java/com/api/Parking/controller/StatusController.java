package com.api.Parking.controller;

import com.api.Parking.dto.request.StatusRequestDto;
import com.api.Parking.dto.response.StatusResponseDto;
import com.api.Parking.service.GarageService;
import com.api.Parking.vo.request.StatusRequest;
import com.api.Parking.vo.response.StatusResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/status")
@RequiredArgsConstructor
@Slf4j
public class StatusController {

    private final ModelMapper modelMapper;
    private final GarageService garageService;

    @GetMapping(value = "/status")
    public ResponseEntity<List<StatusResponse>> getStatus(@RequestBody StatusRequest request) {
        StatusRequestDto requestDto = modelMapper.map(request, StatusRequestDto.class);
        if (requestDto != null) {
            List<StatusResponse> responseDtoList = garageService.getGarage();
            return ResponseEntity.ok(responseDtoList);
        }
        return null;
    }
}