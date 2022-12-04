package com.example.AutomativeSparePartBooking.Repositories;


import com.example.AutomativeSparePartBooking.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

}
