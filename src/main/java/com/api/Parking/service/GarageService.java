package com.api.Parking.service;

import com.api.Parking.dto.request.VehicleRequestDto;
import com.api.Parking.dto.response.VehicleResponseDto;
import com.api.Parking.entity.Garage;

import java.util.Map;

public interface GarageService {
    VehicleResponseDto saveVehicle(VehicleRequestDto requestDto);
    Map<String, Garage> getLastStatus();
    void leave(String order, Integer vehicleNumber);
}
