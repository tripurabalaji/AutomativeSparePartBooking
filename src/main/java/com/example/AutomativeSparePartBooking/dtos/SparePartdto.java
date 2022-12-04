package com.example.AutomativeSparePartBooking.dtos;

import lombok.Data;

@Data
public class SparePartdto {

    private String sparePartName;
    private int numberOfUnitsAvailable;
    private long unitPrice;
    private int quanity;
}
