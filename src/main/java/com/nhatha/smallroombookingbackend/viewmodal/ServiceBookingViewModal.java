package com.nhatha.smallroombookingbackend.viewmodal;

import com.nhatha.smallroombookingbackend.persistance.model.ServiceBooking;

import java.util.Date;

public class ServiceBookingViewModal {
  private int id;
  private Date startAt;
  private Date endAt;
  private int serviceId;
  private int roomBookingId;
  private int adminId;

  public ServiceBookingViewModal() {
  }

  public ServiceBookingViewModal(int id, Date startAt, Date endAt, int serviceId, int roomBookingId, int adminId) {
    this.id = id;
    this.startAt = startAt;
    this.endAt = endAt;
    this.serviceId = serviceId;
    this.roomBookingId = roomBookingId;
    this.adminId = adminId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public int getServiceId() {
    return serviceId;
  }

  public void setServiceId(int serviceId) {
    this.serviceId = serviceId;
  }

  public int getRoomBookingId() {
    return roomBookingId;
  }

  public void setRoomBookingId(int roomBookingId) {
    this.roomBookingId = roomBookingId;
  }

  public int getAdminId() {
    return adminId;
  }

  public void setAdminId(int adminId) {
    this.adminId = adminId;
  }

  public static ServiceBookingViewModal fromServiceBooking(ServiceBooking serviceBooking) {
    return new ServiceBookingViewModal(
        serviceBooking.getId(),
        serviceBooking.getStartAt(),
        serviceBooking.getEndAt(),
        serviceBooking.getService().getId(),
        serviceBooking.getRoomBooking().getId(),
        serviceBooking.getAdmin().getId()
    );
  }
}
