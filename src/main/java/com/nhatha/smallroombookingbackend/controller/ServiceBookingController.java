package com.nhatha.smallroombookingbackend.controller;

import com.nhatha.smallroombookingbackend.error.ServiceBookingNotFoundException;
import com.nhatha.smallroombookingbackend.persistance.model.ServiceBooking;
import com.nhatha.smallroombookingbackend.persistance.repository.ServiceBookingRepository;
import com.nhatha.smallroombookingbackend.persistance.specification.ServiceBookingSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.GregorianCalendar;
import java.util.List;

@RestController
@RequestMapping("service-booking")
public class ServiceBookingController {
  private ServiceBookingRepository serviceBookingRepository;

  @Autowired
  public ServiceBookingController(ServiceBookingRepository serviceBookingRepository) {
    this.serviceBookingRepository = serviceBookingRepository;
  }

  @GetMapping("/admin/{id}")
  public ServiceBooking findByAdminId(@PathVariable int id) {
    return
        serviceBookingRepository
            .findOne(ServiceBookingSpecifications.wasBookedByAdminId(id))
            .orElseThrow(ServiceBookingNotFoundException::new);
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
}
