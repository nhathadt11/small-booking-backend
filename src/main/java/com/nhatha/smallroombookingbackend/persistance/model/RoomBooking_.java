package com.nhatha.smallroombookingbackend.persistance.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(RoomBooking.class)
public abstract class RoomBooking_ {
  public static volatile SingularAttribute<RoomBooking, Integer> id;
  public static volatile SingularAttribute<RoomBooking, String> cusFullName;
  public static volatile SingularAttribute<RoomBooking, String> cusPhone;
  public static volatile SingularAttribute<RoomBooking, String> cusIdentityNo;
  public static volatile SingularAttribute<RoomBooking, Date> startAt;
  public static volatile SingularAttribute<RoomBooking, Date> endAt;
  public static volatile SingularAttribute<RoomBooking, Room> room;
}
