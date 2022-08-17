package com.api.Parking.dto.request;

import com.api.Parking.enums.ActionType;
import com.api.Parking.enums.VehicleType;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class VehicleRequestDto {

    @NotNull
    private ActionType actionType;

    @NotNull
    private String plate;

    @NotNull
    private String color;

    @NotNull
    private VehicleType vehicleType;
}
