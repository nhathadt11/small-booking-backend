package com.nhatha.smallroombookingbackend.viewmodal;

import java.util.List;

public class RoomBookingDetailsViewModal {
  private int id;
  private int roomId;
  private String roomName;
  private float roomPrice;
  private String cusFullName;
  private String cusIdentityNo;
  private String cusPhone;
  private List<ServiceBookingDetails> services;
  private double serviceOverall;
  private double roomOverall;

  public RoomBookingDetailsViewModal(int id,
                                     int roomId,
                                     String roomName,
                                     float roomPrice,
                                     String cusFullName,
                                     String cusIdentityNo,
                                     String cusPhone,
                                     List<ServiceBookingDetails> services,
                                     double serviceOverall,
                                     double roomOverall)
  {
    this.id = id;
    this.roomId = roomId;
    this.roomName = roomName;
    this.roomPrice = roomPrice;
    this.cusFullName = cusFullName;
    this.cusIdentityNo = cusIdentityNo;
    this.cusPhone = cusPhone;
    this.services = services;
    this.serviceOverall = serviceOverall;
    this.roomOverall = roomOverall;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public float getRoomPrice() {
    return roomPrice;
  }

  public void setRoomPrice(float roomPrice) {
    this.roomPrice = roomPrice;
  }

  public String getCusFullName() {
    return cusFullName;
  }

  public void setCusFullName(String cusFullName) {
    this.cusFullName = cusFullName;
  }

  public String getCusIdentityNo() {
    return cusIdentityNo;
  }

  public void setCusIdentityNo(String cusIdentityNo) {
    this.cusIdentityNo = cusIdentityNo;
  }

  public String getCusPhone() {
    return cusPhone;
  }

  public void setCusPhone(String cusPhone) {
    this.cusPhone = cusPhone;
  }

  public List<ServiceBookingDetails> getServices() {
    return services;
  }

  public void setServices(List<ServiceBookingDetails> services) {
    this.services = services;
  }

  public double getServiceOverall() {
    return serviceOverall;
  }

  public void setServiceOverall(double serviceOverall) {
    this.serviceOverall = serviceOverall;
  }

  public double getRoomOverall() {
    return roomOverall;
  }

  public void setRoomOverall(double roomOverall) {
    this.roomOverall = roomOverall;
  }
}
