package com.nhatha.smallroombookingbackend.persistance.repository;

import com.nhatha.smallroombookingbackend.persistance.model.RoomBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RoomBookingRepository extends JpaRepository<RoomBooking, Integer>, JpaSpecificationExecutor<RoomBooking> {
}
