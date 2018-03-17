package com.nhatha.smallroombookingbackend.controller;

import com.nhatha.smallroombookingbackend.error.RoomBookingNotFoundException;
import com.nhatha.smallroombookingbackend.persistance.model.RoomBooking;
import com.nhatha.smallroombookingbackend.persistance.repository.RoomBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("room-booking")
public class RoomBookingController {
  private RoomBookingRepository roomBookingRepository;

  @Autowired
  public RoomBookingController(RoomBookingRepository roomBookingRepository) {
    this.roomBookingRepository = roomBookingRepository;
  }

  @GetMapping()
  public List<RoomBooking> findAll() {
    return roomBookingRepository.findAll();
  }

  @GetMapping("{id}")
  public RoomBooking findOne(@PathVariable int id) {
    return
        roomBookingRepository
        .findById(id)
        .orElseThrow(RoomBookingNotFoundException::new);
  }
}
