package com.api.Parking.service;

import com.api.Parking.dto.request.VehicleRequestDto;
import com.api.Parking.dto.response.VehicleResponseDto;

public interface GarageService {
    VehicleResponseDto saveVehicle(VehicleRequestDto requestDto);
    void leave(String order, Integer vehicleNumber);
}
