package com.nhatha.smallroombookingbackend.controller;

import com.nhatha.smallroombookingbackend.error.RoomBookingNotFoundException;
import com.nhatha.smallroombookingbackend.error.RoomCannotBeBookedException;
import com.nhatha.smallroombookingbackend.error.RoomNotFoundOrNotAvailableException;
import com.nhatha.smallroombookingbackend.error.UnuniqueRoomFoundException;
import com.nhatha.smallroombookingbackend.persistance.model.Admin;
import com.nhatha.smallroombookingbackend.persistance.model.Room;
import com.nhatha.smallroombookingbackend.persistance.model.RoomBooking;
import com.nhatha.smallroombookingbackend.persistance.repository.RoomBookingRepository;
import com.nhatha.smallroombookingbackend.persistance.repository.RoomRepository;
import com.nhatha.smallroombookingbackend.persistance.specification.RoomSpecifications;
import com.nhatha.smallroombookingbackend.utils.WebContextHelper;
import com.nhatha.smallroombookingbackend.viewmodal.RoomBookingViewModal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("room-booking")
public class RoomBookingController {
  private RoomBookingRepository roomBookingRepository;
  private RoomRepository roomRepository;
  private WebContextHelper webContextHelper;

  @Autowired
  public RoomBookingController(RoomBookingRepository roomBookingRepository,
                               RoomRepository roomRepository,
                               WebContextHelper webContextHelper) {
    this.roomBookingRepository = roomBookingRepository;
    this.roomRepository = roomRepository;
    this.webContextHelper = webContextHelper;
  }

  @GetMapping()
  public List<RoomBookingViewModal> findAll() {
    return
        roomBookingRepository
            .findAll()
            .stream()
            .map(RoomBookingViewModal::fromRoomBooking)
            .collect(Collectors.toList());
  }

  @GetMapping("{id}")
  public RoomBookingViewModal findOne(@PathVariable int id) {
    return
        roomBookingRepository
            .findById(id)
            .map(RoomBookingViewModal::fromRoomBooking)
            .orElseThrow(RoomBookingNotFoundException::new);
  }

  @PostMapping()
  public RoomBookingViewModal create(@RequestBody RoomBooking roomBooking) throws RoomCannotBeBookedException {
    Admin admin = webContextHelper.currentUser();
    Room room = roomToBeBooked(roomBooking.getRoomId());

    Optional<RoomBooking> booked = bookRoom(roomBooking, room, admin);
    booked.ifPresent(b -> markRoomAsAvailableOrNot(room, false));

    return booked
        .map(RoomBookingViewModal::fromRoomBooking)
        .orElseThrow(RoomCannotBeBookedException::new);
  }

  private void markRoomAsAvailableOrNot(Room room, boolean available) {
    room.setAvailable(available);
    roomRepository.save(room);
  }

  private Optional<RoomBooking> bookRoom(RoomBooking roomBooking, Room room, Admin admin) {
    return Optional.of(
        roomBookingRepository
            .save(new RoomBooking(
                roomBooking.getCusFullName(),
                roomBooking.getCusPhone(),
                roomBooking.getCusIdentityNo(),
                roomBooking.getStartAt(),
                roomBooking.getEndAt(),
                admin,
                room
            ))
    );
  }

  private Room roomToBeBooked(int id) {
    List<Room> rooms = roomRepository.findAll(RoomSpecifications.isAvailable(id));

    if (rooms.size() > 1) throw new UnuniqueRoomFoundException();
    if (rooms.size() < 1) throw new RoomNotFoundOrNotAvailableException();

    return rooms.get(0);
  }
}
