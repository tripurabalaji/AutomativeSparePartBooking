package com.example.AutomativeSparePartBooking.Controllers;

import com.example.AutomativeSparePartBooking.Entities.Orders;
import com.example.AutomativeSparePartBooking.Entities.SparePart;
import com.example.AutomativeSparePartBooking.Services.OrderService;
import com.example.AutomativeSparePartBooking.Services.SparePartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Automation/User")
public class UserController {

    //1. Book a spare part
    //2. View the spare part
    //3. Book bulk spare parts
    //4. Book multiple spare parts
// User can not book an item if it is out of stock

    @Autowired
    private SparePartService sparePartService;

    @Autowired
    private OrderService orderService;

    @PostMapping("/bookSparePart")//rest endpoints not in camelincase
    public ResponseEntity<Orders> bookSparePart(@RequestBody SparePart sparePart){

        Orders order =  orderService.orderSparePart(sparePart);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/viewSparePart/{id}")
    public ResponseEntity<SparePart> viewSparePart(@PathVariable Long id) {
        SparePart sparePartList = sparePartService.getSpareParts(id);
        return ResponseEntity.ok(sparePartList);
    }

    @PutMapping("bookBulkSpareParts/{id}/{sparepartname}")
    public ResponseEntity<List<Orders>> bookBulkSparePart(@PathVariable Long id, @PathVariable String sparepartname, @RequestBody SparePart sparePart){

        List<Orders> orders =  orderService.orderBulkSparePart(sparePart);
        return ResponseEntity.ok(orders);
    }


}
