package com.api.Parking.service.impl;

import com.api.Parking.dto.request.VehicleRequestDto;
import com.api.Parking.dto.response.StatusResponseDto;
import com.api.Parking.dto.response.VehicleResponseDto;
import com.api.Parking.entity.Garage;
import com.api.Parking.entity.Vehicle;
import com.api.Parking.service.GarageService;
import com.api.Parking.service.StatusService;
import com.api.Parking.validation.Validation;
import com.api.Parking.vo.response.StatusResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class GarageServiceImpl implements GarageService {

    protected final ModelMapper modelMapper;
    protected final Validation validation;
    protected final StatusService statusService;
    protected static List<Garage> garageList = new ArrayList<>();
    protected static Long SLOT = 10L;
    protected static int count = 0;
    protected static int countSlot = 0;
    protected static Map<String, Garage> garageMap = new HashMap<>();

    @PostConstruct
    public void init() {
        garageList.add(Garage.builder().id(1L).status(true).build());
        garageList.add(Garage.builder().id(2L).status(true).build());
        garageList.add(Garage.builder().id(3L).status(true).build());
        garageList.add(Garage.builder().id(4L).status(true).build());
        garageList.add(Garage.builder().id(5L).status(true).build());
        garageList.add(Garage.builder().id(6L).status(true).build());
        garageList.add(Garage.builder().id(7L).status(true).build());
        garageList.add(Garage.builder().id(8L).status(true).build());
        garageList.add(Garage.builder().id(9L).status(true).build());
        garageList.add(Garage.builder().id(10L).status(true).build());
    }

    @Override
    public VehicleResponseDto saveVehicle(VehicleRequestDto requestDto) {
        log.info("saveVehicle() method executed with requestDto{}: ", requestDto);
        VehicleResponseDto responseDto = new VehicleResponseDto();
        Vehicle vehicle = modelMapper.map(requestDto, Vehicle.class);
        setVehicleSlot(requestDto, vehicle);

        log.info("validations running for saveVehicle() method");
        if (validation.checkVehicleRequest(requestDto) != null) {
            responseDto = validation.checkVehicleRequest(requestDto);
            return responseDto;
        }
        if (validation.checkGarageSpace(responseDto, vehicle, SLOT) != null) {
            responseDto = validation.checkGarageSpace(responseDto, vehicle, SLOT);
            return responseDto;
        }

        log.info("saving vehicle to the garage list");
        for (int i = 0; i < requestDto.getVehicleType().getSlot(); i++) {
            garageList.get(count).setVehicle(vehicle);
            garageList.get(count).setStatus(false);
            SLOT--;
            count++;
        }
        responseDto.setMessage("Allocated " + requestDto.getVehicleType().getDesc());
        return responseDto;
    }

    @Override
    public void leave(String order, Integer vehicleNumber) {
        log.info("leave() method executed with parameters order{}, vehicleNumber{} : ",order , vehicleNumber);
        statusService.getLastStatus();
        List<Garage> garageArrayList = new ArrayList<>(garageMap.values());
        Garage removedVehicle = new Garage();
        for (Garage garage : garageArrayList) {
            if (Objects.equals(garage.getId(), Long.valueOf(vehicleNumber))) {
                removedVehicle = garage;
            }
        }

        for (int i = 0; i < garageList.size(); i++) {
            if (garageList.get(i).getVehicle() != null
                    && garageList.get(i).getVehicle().getId() != null
                    && garageList.get(i).getVehicle().getId().equals(removedVehicle.getVehicle().getId())) {
                log.info("removing vehicle from record with id{}: ", removedVehicle.getVehicle().getId());
                garageList.get(i).setStatus(true);
                garageList.get(i).setVehicle(null);
                SLOT++;
            }
        }
    }

    private void setVehicleSlot(VehicleRequestDto requestDto, Vehicle vehicle) {
        List<Long> slotList = new ArrayList<>();
        for (int i = 0; i < requestDto.getVehicleType().getSlot(); i++) {
            slotList.add(Long.valueOf(countSlot + 1));
            countSlot++;
        }
        log.info("setVehicleSlot() method setting vehicle slot with id{}: and slots{}: ", vehicle.getId(), vehicle.getSlot());
        vehicle.setSlot(slotList);
    }
}
