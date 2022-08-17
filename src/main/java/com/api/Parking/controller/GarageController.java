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
        log.info("park() method executed with parameter request{}: ", request);
        VehicleRequestDto requestDto = modelMapper.map(request, VehicleRequestDto.class);
        if (requestDto != null) {
            VehicleResponseDto responseDto = garageService.saveVehicle(requestDto);
            return ResponseEntity.ok(modelMapper.map(responseDto, VehicleResponse.class));
        }
        return null;
    }

    @PostMapping(value = "/leave")
    public void leave(@RequestParam String order,
                      @RequestParam Integer vehicleNumber) {
        log.info("leave() method executed with parameters order{}, vehicleNumber{}: ", order, vehicleNumber);
        garageService.leave(order, vehicleNumber);
    }
}
