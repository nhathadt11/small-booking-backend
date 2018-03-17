package com.nhatha.smallroombookingbackend.persistance.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "room_booking")
public class RoomBooking {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "cus_full_name")
  private String cusFullName;

  @Column(name = "cus_phone")
  private String cusPhone;

  @Column(name = "cus_identity_no")
  private String cusIdentityNo;

  @Column(name = "start_at")
  private Date startAt;

  @Column(name = "end_at")
  private Date endAt;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "room_id", nullable = false)
  private Room room;

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

  public Room getRoom() {
    return room;
  }

  public void setRoom(Room room) {
    this.room = room;
  }
}
