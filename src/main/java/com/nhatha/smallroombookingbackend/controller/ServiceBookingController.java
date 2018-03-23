package com.nhatha.smallroombookingbackend.controller;

import com.nhatha.smallroombookingbackend.error.RoomBookingNotFoundException;
import com.nhatha.smallroombookingbackend.error.ServiceCannotBeBookedException;
import com.nhatha.smallroombookingbackend.persistance.model.Admin;
import com.nhatha.smallroombookingbackend.persistance.model.RoomBooking;
import com.nhatha.smallroombookingbackend.persistance.model.Service;
import com.nhatha.smallroombookingbackend.persistance.model.ServiceBooking;
import com.nhatha.smallroombookingbackend.persistance.repository.RoomBookingRepository;
import com.nhatha.smallroombookingbackend.persistance.repository.ServiceBookingRepository;
import com.nhatha.smallroombookingbackend.persistance.repository.ServiceRepository;
import com.nhatha.smallroombookingbackend.persistance.specification.ServiceBookingSpecifications;
import com.nhatha.smallroombookingbackend.utils.WebContextHelper;
import com.nhatha.smallroombookingbackend.viewmodal.ServiceBookingViewModal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.ServiceNotFoundException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("service-booking")
public class ServiceBookingController {
  private ServiceBookingRepository serviceBookingRepository;
  private ServiceRepository serviceRepository;
  private RoomBookingRepository roomBookingRepository;
  private WebContextHelper webContextHelper;

  @Autowired
  public ServiceBookingController(ServiceBookingRepository serviceBookingRepository,
                                  ServiceRepository serviceRepository,
                                  RoomBookingRepository roomBookingRepository,
                                  WebContextHelper webContextHelper) {
    this.serviceBookingRepository = serviceBookingRepository;
    this.serviceRepository = serviceRepository;
    this.roomBookingRepository = roomBookingRepository;
    this.webContextHelper = webContextHelper;
  }

  @GetMapping("/admin/{id}")
  public List<ServiceBooking> findByAdminId(@PathVariable int id) {
    return
        serviceBookingRepository
            .findAll(ServiceBookingSpecifications.wasBookedByAdminId(id));
  }

  @GetMapping("/from-to")
  public List<ServiceBooking> findBetween(@RequestParam("yearFrom") int yearFrom,
                                          @RequestParam("monthFrom") int monthFrom,
                                          @RequestParam("dateFrom") int dateFrom,
                                          @RequestParam("yearTo") int yearTo,
                                          @RequestParam("monthTo") int monthTo,
                                          @RequestParam("dateTo") int dateTo) {
    return serviceBookingRepository
        .findAll(ServiceBookingSpecifications.wasBookedBetween(
            new GregorianCalendar(yearFrom, monthFrom, dateFrom).getTime(),
            new GregorianCalendar(yearTo, monthTo, dateTo).getTime()
        ));
  }

  @PostMapping()
  public ServiceBookingViewModal create(@RequestBody ServiceBooking serviceBooking)
      throws ServiceNotFoundException {
    Admin admin = webContextHelper.currentUser();
    RoomBooking roomBooking = roomBookingById(serviceBooking.getRoomBookingId());
    Service service = serviceById(serviceBooking.getServiceId());

    return
        bookService(serviceBooking, service, roomBooking, admin)
            .map(ServiceBookingViewModal::fromServiceBooking)
            .orElseThrow(ServiceCannotBeBookedException::new);
  }

  private Service serviceById(int serviceId) throws ServiceNotFoundException {
    return
        serviceRepository
            .findById(serviceId)
            .orElseThrow(ServiceNotFoundException::new);
  }

  private RoomBooking roomBookingById(int roomBookingId) {
    return
        roomBookingRepository
            .findById(roomBookingId)
            .orElseThrow(RoomBookingNotFoundException::new);
  }

  private Optional<ServiceBooking> bookService(ServiceBooking serviceBooking,
                                               Service service,
                                               RoomBooking roomBooking,
                                               Admin admin) {
    return Optional.of(
        serviceBookingRepository.save(
            new ServiceBooking(
                serviceBooking.getStartAt(),
                serviceBooking.getEndAt(),
                service,
                roomBooking,
                admin
            )
        )
    );
  }

}
