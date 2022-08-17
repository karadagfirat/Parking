package com.api.Parking.controller;

import com.api.Parking.entity.Garage;
import com.api.Parking.service.StatusService;
import com.api.Parking.vo.request.StatusRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/status")
@RequiredArgsConstructor
@Slf4j
public class StatusController {

    private final StatusService statusService;

    @GetMapping(value = "/status")
    public ResponseEntity<Map<String, Garage>> getStatus(@RequestBody StatusRequest request) {
        log.info("leave() method executed with parameter request{} : ", request);
        Map<String, Garage> garageMap = statusService.getLastStatus();
        return ResponseEntity.ok(garageMap);
    }
}