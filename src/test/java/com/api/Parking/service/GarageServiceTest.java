package com.api.Parking.service;

import com.api.Parking.dto.request.VehicleRequestDto;
import com.api.Parking.dto.response.VehicleResponseDto;
import com.api.Parking.entity.Vehicle;
import com.api.Parking.enums.ActionType;
import com.api.Parking.enums.VehicleType;
import com.api.Parking.service.impl.GarageServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.util.Collections;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GarageServiceTest {

    @InjectMocks
    private GarageServiceImpl garageService;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private Vehicle vehicle;

    @Test
    public void saveVehicle() {
        //given
        VehicleRequestDto requestDto = new VehicleRequestDto();
        requestDto.setColor("Pink");
        requestDto.setVehicleType(VehicleType.CAR);
        requestDto.setPlate("34-ABC-123");
        requestDto.setActionType(ActionType.PARK);

        VehicleResponseDto responseDto = new VehicleResponseDto();
        responseDto.setMessage("Allocated " + requestDto.getVehicleType().getDesc());

        vehicle.setSlot(Collections.singletonList(1L));
        vehicle.setVehicleType(VehicleType.CAR);
        vehicle.setColor("Pink");
        vehicle.setPlate("34-ABC-123");
        vehicle.setActionType(ActionType.PARK);

        vehicle = modelMapper.map(vehicle, Vehicle.class);

        //when
        when(garageService.saveVehicle(requestDto)).thenReturn(responseDto);
        when(modelMapper.map(requestDto, Vehicle.class)).thenReturn(vehicle);

        //action
        VehicleResponseDto responseDtoActual = garageService.saveVehicle(requestDto);

        //then
        Assert.assertEquals(responseDto, responseDtoActual);
    }
}
