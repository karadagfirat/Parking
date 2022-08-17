package com.api.Parking.controller;

import com.api.Parking.dto.request.VehicleRequestDto;
import com.api.Parking.dto.response.VehicleResponseDto;
import com.api.Parking.service.GarageService;
import com.api.Parking.vo.request.VehicleRequest;
import com.api.Parking.vo.response.VehicleResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/garage")
@RequiredArgsConstructor
@Slf4j
public class GarageController {

    private final ModelMapper modelMapper;
    private final GarageService garageService;

    @PostMapping(value = "/park")
    public ResponseEntity<VehicleResponse> park(@RequestBody VehicleRequest request) {
        VehicleRequestDto requestDto = modelMapper.map(request, VehicleRequestDto.class);
        if (requestDto != null) {
            VehicleResponseDto responseDto = garageService.saveVehicle(requestDto);
            return ResponseEntity.ok(modelMapper.map(responseDto, VehicleResponse.class));
        }
        return ResponseEntity.ok(new VehicleResponse());
    }

    @PostMapping(value = "/leave")
    public void leave(@RequestParam String order,
                      @RequestParam Integer vehicleNumber) {
        garageService.leave(order, vehicleNumber);
    }
}
