package com.api.Parking.enums;

public enum VehicleType {

    CAR(1, "1 slot"),
    JEEP(2, "2 slots"),
    TRUCK(4, "4 slots");

    private int slot ;
    private String desc ;


    VehicleType(int slot, String desc) {
        this.slot = slot;
        this.desc = desc;
    }

    public int getSlot() {
        return slot;
    }
    public String getDesc() {
        return desc;
    }
}
