package com.api.Parking.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Garage {

    private Long id;
    private Boolean status;
    private Vehicle vehicle;
}
