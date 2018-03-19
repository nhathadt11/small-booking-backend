package com.nhatha.smallroombookingbackend.persistance.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(ServiceBooking.class)
public abstract class ServiceBooking_ {
  public static volatile SingularAttribute<ServiceBooking, Date> startAt;
  public static volatile SingularAttribute<ServiceBooking, Date> endAt;
  public static volatile SingularAttribute<ServiceBooking, Integer> serviceId;
  public static volatile SingularAttribute<ServiceBooking, Integer> roomBookingId;
  public static volatile SingularAttribute<ServiceBooking, Admin> admin;
  public static volatile SingularAttribute<ServiceBooking, Integer> adminId;
}
