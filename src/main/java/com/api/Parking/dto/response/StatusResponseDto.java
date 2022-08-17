package com.api.Parking.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class StatusResponseDto {
    private String plate;
    private String color;
    private List<Long> slots;
}
