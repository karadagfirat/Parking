package com.api.Parking.service;

import com.api.Parking.entity.Garage;

import java.util.Map;

public interface StatusService {
    Map<String, Garage> getLastStatus();
}
