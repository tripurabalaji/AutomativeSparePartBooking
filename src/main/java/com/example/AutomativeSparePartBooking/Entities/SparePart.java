package com.example.AutomativeSparePartBooking.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class SparePart extends BaseModel {

    private String sparePartName;
    private int numberOfUnitsAvailable;
    private long unitPrice;
    private int quanity;

    public String getSparePartName() {
        return sparePartName;
    }

    public void setSparePartName(String sparePartName) {
        this.sparePartName = sparePartName;
    }

    public int getNumberOfUnitsAvailable() {
        return numberOfUnitsAvailable;
    }

    public void setNumberOfUnitsAvailable(int numberOfUnitsAvailable) {
        this.numberOfUnitsAvailable = numberOfUnitsAvailable;
    }

    public long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public SparePart() {
    }

    public SparePart(String sparePartName, int numberOfUnitsAvailable, long unitPrice, int quanity) {
        this.sparePartName = sparePartName;
        this.numberOfUnitsAvailable = numberOfUnitsAvailable;
        this.unitPrice = unitPrice;
        this.quanity = quanity;
    }

    /*    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders orders;*/
}
