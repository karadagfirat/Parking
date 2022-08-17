package com.api.Parking.validation;

import com.api.Parking.dto.request.VehicleRequestDto;
import com.api.Parking.dto.response.VehicleResponseDto;
import com.api.Parking.entity.Vehicle;
import com.api.Parking.enums.ActionType;
import com.api.Parking.enums.VehicleType;
import org.springframework.stereotype.Service;

@Service
public class Validation {

    public VehicleResponseDto checkVehicleRequest(VehicleRequestDto request) {
        VehicleResponseDto responseDto = new VehicleResponseDto();
        if (request.getColor() == null || !(request.getColor() instanceof String)) {
            responseDto.setMessage("Girilen Renk Hatalıdır!");
        }
        if (request.getVehicleType() == null || !(request.getVehicleType() instanceof VehicleType) ||
                (!VehicleType.CAR.equals(request.getVehicleType())
                        && !VehicleType.JEEP.equals(request.getVehicleType())
                        && !VehicleType.TRUCK.equals(request.getVehicleType()))) {
            responseDto.setMessage("Girilen Araç Tipi Hatalıdır!");
        }
        if (request.getActionType() == null || !(request.getActionType() instanceof ActionType) ||
                (!ActionType.PARK.equals(request.getActionType())
                        && !ActionType.LEAVE.equals(request.getActionType())
                        && !ActionType.STATUS.equals(request.getActionType()))) {
            responseDto.setMessage("Girilen Aksiyon Hatalıdır!");
        }
        if (request.getPlate() == null || !(request.getColor() instanceof String)) {
            responseDto.setMessage("Girilen Plaka Hatalıdır!");
        }
        return null;
    }

    public VehicleResponseDto checkGarageSpace(VehicleResponseDto responseDto, Vehicle vehicle, Long slot) {
        if (vehicle.getVehicleType().getSlot() > slot) {
            responseDto.setMessage("Garage is full!");
            return responseDto;
        }
        return null;
    }
}
