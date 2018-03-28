package com.nhatha.smallroombookingbackend.viewmodal;

import com.nhatha.smallroombookingbackend.persistance.model.ServiceBooking;

import java.util.Date;

public class ServiceBookingDetails {
  private String serviceName;
  private Date startAt;
  private Date endAt;
  private float price;

  public ServiceBookingDetails(String serviceName, Date startAt, Date endAt, float price) {
    this.serviceName = serviceName;
    this.startAt = startAt;
    this.endAt = endAt;
    this.price = price;
  }

  public String getServiceName() {
    return serviceName;
  }

  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
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

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public static ServiceBookingDetails fromServiceBooking(ServiceBooking serviceBooking) {
    return new ServiceBookingDetails(
        serviceBooking.getService().getName(),
        serviceBooking.getStartAt(),
        serviceBooking.getEndAt(),
        serviceBooking.getService().getPrice()
    );
  }
}
