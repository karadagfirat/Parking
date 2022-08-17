package com.api.Parking.service;

import com.api.Parking.dto.request.VehicleRequestDto;
import com.api.Parking.dto.response.VehicleResponseDto;
import com.api.Parking.vo.response.StatusResponse;

import java.util.List;

public interface GarageService {
    VehicleResponseDto saveVehicle(VehicleRequestDto requestDto);
    List<StatusResponse> getLastStatus();
    void leave(String order, Integer vehicleNumber);
}
