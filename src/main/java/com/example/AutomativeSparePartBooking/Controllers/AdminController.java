package com.example.AutomativeSparePartBooking.Controllers;

import com.example.AutomativeSparePartBooking.Entities.SparePart;
import com.example.AutomativeSparePartBooking.Exceptions.SparePartDuplicateException;
import com.example.AutomativeSparePartBooking.Services.SparePartService;
import com.example.AutomativeSparePartBooking.dtos.SparePartdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Automation/Admin")
public class AdminController {

    //1. Add a spare part
    //2. View the spare parts
    //3. Remove the spare parts
    //4. Update the details of spare parts
    //5. Update the stock/inventory of spare

    @Autowired
    private SparePartService sparePartService;

    @PostMapping("/add-sparepart")
    public ResponseEntity<SparePartdto> addSparePart(@RequestBody SparePartdto sparePart) {//TODO: validate the requestBody parameters
        try {
            sparePartService.addSparePart(sparePart);
        } catch (SparePartDuplicateException e) {
            throw new SparePartDuplicateException(HttpStatus.CONFLICT, "spare already exists", e);
        }//Exceptions
        return new ResponseEntity<>(sparePart, HttpStatus.ACCEPTED);

        //TODO: Use DTO, ObjectMapper, ResponseEntity with URL, status, Validations etc
    }

    @GetMapping("/spareparts")
    public ResponseEntity<List<SparePart>> getAllSpareParts() {
        List<SparePart> sparePartList = sparePartService.getAllSpareParts();
        return ResponseEntity.ok(sparePartList);
    }

    @DeleteMapping("/remove-sparepart/{id}")//return the response along with error
    public void removeSparePart(@PathVariable Long id) {
        sparePartService.removeSparePart(id);
    }

    @PutMapping("/update-sparepart-details/{id}/{sparepartname}")
    public ResponseEntity<SparePart> updateSparePartDetails(@PathVariable Long id, @PathVariable String sparepartname, @RequestBody SparePart sparePart) {
        SparePart sparePart1 = sparePartService.updateSparePartDetails(sparePart, id, sparepartname);
        return ResponseEntity.ok(sparePart1);
    }
}
