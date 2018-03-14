package com.nhatha.smallroombookingbackend.persistance.model;

import javax.persistence.*;

@Entity
public class Admin {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column
  private String firstName;

  @Column
  private String lastName;

  @Column
  private String phone;

  @Column
  private String email;

  @Column
  private String address;

  @Column
  private boolean isActive;

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
    return isActive;
  }

  public void setActive(boolean active) {
    isActive = active;
  }
}
