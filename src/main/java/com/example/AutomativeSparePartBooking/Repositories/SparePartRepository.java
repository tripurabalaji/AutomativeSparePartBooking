package com.example.AutomativeSparePartBooking.Repositories;

import com.example.AutomativeSparePartBooking.Entities.SparePart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SparePartRepository extends JpaRepository<SparePart, Long> {

    public SparePart findBySparePartName(String sparePartName);
}
