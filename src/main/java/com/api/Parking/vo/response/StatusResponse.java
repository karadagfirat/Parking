package com.api.Parking.vo.response;

import lombok.Data;

import java.util.List;

@Data
public class StatusResponse {
    private String plate;
    private String color;
    private List<Long> slots;
}
