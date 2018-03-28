package com.nhatha.smallroombookingbackend.controller;

import com.nhatha.smallroombookingbackend.error.RoomBookingNotFoundException;
import com.nhatha.smallroombookingbackend.persistance.model.RoomBooking;
import com.nhatha.smallroombookingbackend.persistance.model.ServiceBooking;
import com.nhatha.smallroombookingbackend.persistance.repository.RoomBookingRepository;
import com.nhatha.smallroombookingbackend.persistance.repository.ServiceBookingRepository;
import com.nhatha.smallroombookingbackend.persistance.specification.ServiceBookingSpecifications;
import com.nhatha.smallroombookingbackend.viewmodal.RoomBookingDetailsViewModal;
import com.nhatha.smallroombookingbackend.viewmodal.ServiceBookingDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("users")
public class UserController {
  private RoomBookingRepository roomBookingRepository;
  private ServiceBookingRepository serviceBookingRepository;

  @Autowired
  public UserController(RoomBookingRepository roomBookingRepository,
                        ServiceBookingRepository serviceBookingRepository) {
    this.roomBookingRepository = roomBookingRepository;
    this.serviceBookingRepository = serviceBookingRepository;
  }

  @GetMapping("/booking-details/{bookingId}")
  public RoomBookingDetailsViewModal findRoomBookDetails(@PathVariable int bookingId) {
     RoomBooking roomBooking               = roomBookingById(bookingId);
     List<ServiceBooking> serviceBookings  = serviceBookingListByBookingId(roomBooking.getId());
     List<ServiceBookingDetails> services  = fromServiceBookingList(serviceBookings);

     float serviceOverall  = calculateServiceBookingOverall(serviceBookings);
     float roomOverall     = calculateRoomBookingOverall(roomBooking, serviceOverall);

     return new RoomBookingDetailsViewModal(
         roomBooking.getId(),
         roomBooking.getRoom().getId(),
         roomBooking.getRoom().getName(),
         roomBooking.getRoom().getPrice(),
         roomBooking.getCusFullName(),
         roomBooking.getCusIdentityNo(),
         roomBooking.getCusPhone(),
         services,
         serviceOverall,
         roomOverall
     );
  }

  private RoomBooking roomBookingById(int id) {
    return roomBookingRepository
        .findById(id)
        .orElseThrow(RoomBookingNotFoundException::new);
  }

  private List<ServiceBooking> serviceBookingListByBookingId(int id) {
    return serviceBookingRepository
        .findAll(ServiceBookingSpecifications.hasRoomBookingId(id));
  }

  private List<ServiceBookingDetails> fromServiceBookingList(List<ServiceBooking> serviceBookings) {
    return serviceBookings
        .stream()
        .map(ServiceBookingDetails::fromServiceBooking)
        .collect(Collectors.toList());
  }

  private float calculateServiceBookingOverall(List<ServiceBooking> serviceBookings) {
    return serviceBookings
        .stream()
        .map(sb -> sb.getService().getPrice())
        .reduce(0f, (acc, price) -> acc + price);
  }

  private float calculateRoomBookingOverall(RoomBooking roomBooking, List<ServiceBooking> serviceBookings) {
    return roomBooking.getRoom().getPrice() + calculateServiceBookingOverall(serviceBookings);
  }

  private float calculateRoomBookingOverall(RoomBooking roomBooking, float serviceOverall) {
    return roomBooking.getRoom().getPrice() + serviceOverall;
  }
}
