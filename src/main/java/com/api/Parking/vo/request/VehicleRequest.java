package com.api.Parking.vo.request;

import javax.validation.constraints.NotNull;

import com.api.Parking.enums.ActionType;
import com.api.Parking.enums.VehicleType;
import lombok.Data;

@Data
public class VehicleRequest {

    private Long vehicleNumber;

    @NotNull
    private ActionType actionType;

    @NotNull
    private String plate;

    @NotNull
    private String color;

    @NotNull
    private VehicleType vehicleType;
}
