package com.nhatha.smallroombookingbackend.persistance.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nhatha.smallroombookingbackend.viewmodal.RoomBookingViewModal;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "room")
public class Room {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false, unique = true)
  private String name;

  @Column
  private String description;

  @Column
  private int capacity;

  @Column
  private float price;

  @Column
  private boolean available;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "room")
  private Set<RoomBooking> roomBookings;

  @ManyToOne(fetch = FetchType.EAGER)
  private Admin admin;

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

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public boolean isAvailable() {
    return available;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }

  @JsonIgnore
  public Set<RoomBooking> getRoomBookings() {
    return roomBookings;
  }

  public void setRoomBookings(Set<RoomBooking> roomBookings) {
    this.roomBookings = roomBookings;
  }

  @JsonIgnore
  public Admin getAdmin() {
    return admin;
  }

  public void setAdmin(Admin admin) {
    this.admin = admin;
  }
}
