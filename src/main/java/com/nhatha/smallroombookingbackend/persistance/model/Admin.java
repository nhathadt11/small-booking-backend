package com.nhatha.smallroombookingbackend.persistance.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "admin")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Admin {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column
  private String phone;

  @Column
  private String email;

  @Column
  private String address;

  @Column
  private boolean active;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "admin")
  private Set<ServiceBooking> serviceBookings;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "admin")
  private Set<RoomBooking> roomBookings;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "admin")
  private Set<Service> services;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "admin")
  private Set<Room> rooms;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  @JsonIgnore
  public Set<ServiceBooking> getServiceBookings() {
    return serviceBookings;
  }

  public void setServiceBookings(Set<ServiceBooking> serviceBookings) {
    this.serviceBookings = serviceBookings;
  }

  @JsonIgnore
  public Set<RoomBooking> getRoomBookings() {
    return roomBookings;
  }

  public void setRoomBookings(Set<RoomBooking> roomBookings) {
    this.roomBookings = roomBookings;
  }

  @JsonIgnore
  public Set<Service> getServices() {
    return services;
  }

  public void setServices(Set<Service> services) {
    this.services = services;
  }

  @JsonIgnore
  public Set<Room> getRooms() {
    return rooms;
  }

  public void setRooms(Set<Room> rooms) {
    this.rooms = rooms;
  }
}
