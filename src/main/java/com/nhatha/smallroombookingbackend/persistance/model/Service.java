package com.nhatha.smallroombookingbackend.persistance.model;

import javax.persistence.*;
import java.util.Date;

@Entity
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

  @Column(name = "admin_id")
  private Date adminId;

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

  public Date getAdminId() {
    return adminId;
  }

  public void setAdminId(Date adminId) {
    this.adminId = adminId;
  }
}
