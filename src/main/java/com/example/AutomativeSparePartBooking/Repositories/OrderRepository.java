package com.example.AutomativeSparePartBooking.Repositories;

import com.example.AutomativeSparePartBooking.Entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;



public interface OrderRepository extends JpaRepository<Orders, Long> {
}
