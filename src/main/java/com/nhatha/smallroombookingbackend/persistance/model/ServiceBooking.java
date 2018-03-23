package com.nhatha.smallroombookingbackend.persistance.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "service_booking")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ServiceBooking {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "start_at")
  private Date startAt;

  @Column(name = "end_at")
  private Date endAt;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "service_id", nullable = false)
  private Service service;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "room_booking_id", nullable = false)
  private RoomBooking roomBooking;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "admin_id", nullable = false)
  private Admin admin;

  @Column(name = "admin_id", insertable = false, updatable = false)
  private int adminId;

  @Column(name = "room_booking_id", insertable = false, updatable = false)
  private int roomBookingId;

  @Column(name = "service_id", insertable = false, updatable = false)
  private int serviceId;

  public ServiceBooking() {
  }

  public ServiceBooking(Date startAt, Date endAt, Service service, RoomBooking roomBooking, Admin admin) {
    this.startAt = startAt;
    this.endAt = endAt;
    this.service = service;
    this.roomBooking = roomBooking;
    this.admin = admin;
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

  @JsonIgnore
  public Service getService() {
    return service;
  }

  public void setService(Service service) {
    this.service = service;
  }

  @JsonIgnore
  public RoomBooking getRoomBooking() {
    return roomBooking;
  }

  public void setRoomBooking(RoomBooking roomBooking) {
    this.roomBooking = roomBooking;
  }

  @JsonIgnore
  public Admin getAdmin() {
    return admin;
  }

  public void setAdmin(Admin admin) {
    this.admin = admin;
  }

  public int getAdminId() {
    return this.adminId;
  }

  public void setAdminId(int adminId) {
    this.adminId = adminId;
  }

  public int getRoomBookingId() {
    return roomBookingId;
  }

  public void setRoomBookingId(int roomBookingId) {
    this.roomBookingId = roomBookingId;
  }

  public int getServiceId() {
    return serviceId;
  }

  public void setServiceId(int serviceId) {
    this.serviceId = serviceId;
  }
}
