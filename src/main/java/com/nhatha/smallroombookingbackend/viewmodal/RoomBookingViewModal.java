package com.nhatha.smallroombookingbackend.viewmodal;

import com.nhatha.smallroombookingbackend.persistance.model.RoomBooking;

import java.util.Date;

public class RoomBookingViewModal {
  private int id;
  private String cusFullName;
  private String cusPhone;
  private String cusIdentityNo;
  private Date startAt;
  private Date endAt;
  private int roomId;
  private String roomName;

  public RoomBookingViewModal(
      int id, String cusFullName, String cusPhone, String cusIdentityNo,
      Date startAt, Date endAt, int roomId, String roomName
  ) {
    this.id = id;
    this.cusFullName = cusFullName;
    this.cusPhone = cusPhone;
    this.cusIdentityNo = cusIdentityNo;
    this.startAt = startAt;
    this.endAt = endAt;
    this.roomId = roomId;
    this.roomName = roomName;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCusFullName() {
    return cusFullName;
  }

  public void setCusFullName(String cusFullName) {
    this.cusFullName = cusFullName;
  }

  public String getCusPhone() {
    return cusPhone;
  }

  public void setCusPhone(String cusPhone) {
    this.cusPhone = cusPhone;
  }

  public String getCusIdentityNo() {
    return cusIdentityNo;
  }

  public void setCusIdentityNo(String cusIdentityNo) {
    this.cusIdentityNo = cusIdentityNo;
  }

  public Date getStartAt() {
    return startAt;
  }

  public void setStartAt(Date startAt) {
    this.startAt = startAt;
  }

  public Date getEndAt() {
    return endAt;
  }

  public void setEndAt(Date endAt) {
    this.endAt = endAt;
  }

  public int getRoomId() {
    return roomId;
  }

  public void setRoomId(int roomId) {
    this.roomId = roomId;
  }

  public String getRoomName() {
    return roomName;
  }

  public void setRoomName(String roomName) {
    this.roomName = roomName;
  }

  public static RoomBookingViewModal fromRoomBooking(RoomBooking roomBooking) {
    return new RoomBookingViewModal(
        roomBooking.getId(),
        roomBooking.getCusFullName(),
        roomBooking.getCusPhone(),
        roomBooking.getCusIdentityNo(),
        roomBooking.getStartAt(),
        roomBooking.getEndAt(),
        roomBooking.getRoom().getId(),
        roomBooking.getRoom().getName()
    );
  }
}
