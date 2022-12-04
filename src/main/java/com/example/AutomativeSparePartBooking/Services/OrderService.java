package com.example.AutomativeSparePartBooking.Services;

import com.example.AutomativeSparePartBooking.Entities.OrderStatus;
import com.example.AutomativeSparePartBooking.Entities.Orders;
import com.example.AutomativeSparePartBooking.Entities.SparePart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private SparePartService sparePartService;

    public Orders orderSparePart(SparePart sparePartRequested) {
        //call to sparePartService and check if it is available or not

        Orders orders= null;
        SparePart sparePart1 = sparePartService.getSpareParts(sparePartRequested.getId());
        if(sparePart1.getNumberOfUnitsAvailable()>0) {
             orders = bookOrder(sparePart1, sparePartRequested);
        }
        return orders;
    }

    public Orders bookOrder(SparePart sparePartList, SparePart sparePartRequested) {
        int numberOfAvailableSpareParts = sparePartList.getNumberOfUnitsAvailable();
        numberOfAvailableSpareParts--;

        //subtract 1 order
        sparePartList.setNumberOfUnitsAvailable(numberOfAvailableSpareParts);
       // SparePart sparePart = sparePartService.updateSparePartDetails(sparePartList,);

        Orders orders = new Orders();
        orders.setOrderDate(new Date());
        orders.setPrice(sparePartRequested.getUnitPrice());
        orders.setQuantity(sparePartRequested.getQuanity());
        orders.setOrderStatus(OrderStatus.COMPLETED);

        return orders;
    }

    public List<Orders> orderBulkSparePart(SparePart sparePart) {
        return null;
    }
}
