package com.nhatha.smallroombookingbackend.persistance.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(RoomBooking.class)
public abstract class RoomBooking_ {
  public static SingularAttribute<RoomBooking, Integer> id;
  public static SingularAttribute<RoomBooking, String> cusFullName;
  public static SingularAttribute<RoomBooking, String> cusPhone;
  public static SingularAttribute<RoomBooking, String> cusIdentityNo;
  public static SingularAttribute<RoomBooking, Date> startAt;
  public static SingularAttribute<RoomBooking, Date> endAt;
  public static SingularAttribute<RoomBooking, Room> room;
}
