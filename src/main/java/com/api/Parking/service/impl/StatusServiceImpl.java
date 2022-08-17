package com.api.Parking.service.impl;

import com.api.Parking.entity.Garage;
import com.api.Parking.service.StatusService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.api.Parking.service.impl.GarageServiceImpl.SLOT;
import static com.api.Parking.service.impl.GarageServiceImpl.garageList;

@Service
@RequiredArgsConstructor
@Slf4j
public class StatusServiceImpl implements StatusService {

    @Override
    public Map<String, Garage> getLastStatus() {
        Map<String, Garage> garageMapStatus = GarageServiceImpl.garageMap;
        log.info("getLastStatus() method executed");
        garageMapStatus.clear();
        for (Garage garage : garageList) {
            if (garage.getVehicle() != null) {
                garageMapStatus.put(garage.getVehicle().getId(), garage);
            }
        }
        System.out.println(SLOT);
        return garageMapStatus;
    }

}
