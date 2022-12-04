package com.example.AutomativeSparePartBooking.Services;

import com.example.AutomativeSparePartBooking.Entities.SparePart;
import com.example.AutomativeSparePartBooking.Exceptions.SparePartDuplicateException;
import com.example.AutomativeSparePartBooking.Exceptions.SparePartNotAvailableException;
import com.example.AutomativeSparePartBooking.Repositories.SparePartRepository;
import com.example.AutomativeSparePartBooking.dtos.SparePartdto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SparePartService {

    @Autowired
    private SparePartRepository sparePartRepository;

    public List<SparePart> getAllSpareParts() {
        return sparePartRepository.findAll();
    }

    public SparePart addSparePart(SparePartdto sparePart) {
        SparePart spare_Part = sparePartRepository.findBySparePartName(sparePart.getSparePartName());

        if(spare_Part != null){
            throw new SparePartDuplicateException("Spare part already exist with id: "+ sparePart);
        }

        SparePart sparePart1 = new SparePart();
        sparePart1.setSparePartName(sparePart.getSparePartName());
        sparePart1.setUnitPrice(sparePart.getUnitPrice());
        sparePart1.setNumberOfUnitsAvailable(sparePart.getNumberOfUnitsAvailable());

        return sparePartRepository.save(sparePart1);
    }

    public void removeSparePart(Long id) {
        SparePart sparePart = sparePartRepository.findById(id).get();
        sparePartRepository.delete(sparePart);
    }

    public SparePart updateSparePartDetails(SparePart sparePart, Long id, String sparepartName) {
        SparePart sparePart1 = sparePartRepository.findById(id).orElseThrow(() ->new SparePartNotAvailableException("Id of spare part is not found -"+ id));


        sparePart1.setSparePartName(sparePart.getSparePartName());
        sparePart1.setUnitPrice(sparePart.getUnitPrice());
        sparePart1.setNumberOfUnitsAvailable(sparePart.getNumberOfUnitsAvailable());

        return sparePart1;
    }

    public SparePart getSpareParts(Long id) {
        SparePart sparePart1 = sparePartRepository.findById(id).orElseThrow(() -> new SparePartNotAvailableException("No spare parts available"));
        return sparePart1;
    }
}
