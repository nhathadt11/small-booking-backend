package com.nhatha.smallroombookingbackend.persistance.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(ServiceBooking.class)
public abstract class ServiceBooking_ {
  public static SingularAttribute<ServiceBooking, Date> startAt;
  public static SingularAttribute<ServiceBooking, Date> endAt;
  public static SingularAttribute<ServiceBooking, Integer> serviceId;
  public static SingularAttribute<ServiceBooking, Integer> roomBookingId;
  public static SingularAttribute<ServiceBooking, Admin> admin;
  public static SingularAttribute<ServiceBooking, Integer> adminId;
}
