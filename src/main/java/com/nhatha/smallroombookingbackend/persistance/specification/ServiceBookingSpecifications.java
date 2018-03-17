package com.nhatha.smallroombookingbackend.persistance.specification;

import com.nhatha.smallroombookingbackend.persistance.model.ServiceBooking;
import com.nhatha.smallroombookingbackend.persistance.model.ServiceBooking_;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public final class ServiceBookingSpecifications {
  public static Specification<ServiceBooking> wasBookedByAdminId(int id) {
    return (root, query, cb) -> cb.equal(root.get(ServiceBooking_.adminId), id);
  }

  public static Specification<ServiceBooking> wasBookedBetween(Date from, Date to) {
    return (root, query, cb) -> cb.between(root.get(ServiceBooking_.startAt), from, to);
  }
}
