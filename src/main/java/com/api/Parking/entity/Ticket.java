package com.api.Parking.entity;

import lombok.Data;

import java.util.UUID;

@Data
public class Ticket {

    private String id = UUID.randomUUID().toString();
}
