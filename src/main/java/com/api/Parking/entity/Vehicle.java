package com.api.Parking.entity;

import com.api.Parking.enums.ActionType;
import com.api.Parking.enums.VehicleType;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Vehicle {

    private String id = UUID.randomUUID().toString();
    private String plate;
    private String color;
    private VehicleType vehicleType;
    private ActionType actionType;
    private List<Long> slot;
}
