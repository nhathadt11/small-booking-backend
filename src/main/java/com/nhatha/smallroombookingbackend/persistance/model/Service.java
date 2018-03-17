package com.nhatha.smallroombookingbackend.persistance.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "service")
public class Service {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column
  private String name;

  @Column
  private String description;

  @Column
  private float price;

  @ManyToOne(fetch = FetchType.EAGER)
  private Admin admin;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "service")
  private Set<ServiceBooking> serviceBookings;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  @JsonIgnore
  public Admin getAdmin() {
    return admin;
  }

  public void setAdmin(Admin admin) {
    this.admin = admin;
  }

  @JsonIgnore
  public Set<ServiceBooking> getServiceBookings() {
    return serviceBookings;
  }

  public void setServiceBookings(Set<ServiceBooking> serviceBookings) {
    this.serviceBookings = serviceBookings;
  }
}
