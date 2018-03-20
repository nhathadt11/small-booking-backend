package com.nhatha.smallroombookingbackend.config.security;

import java.util.Date;

public class TokenModel {
  private String accessToken;
  private Date expireAt;

  public TokenModel() {
  }

  public TokenModel(String accessToken, Date expireAt) {
    this.accessToken = accessToken;
    this.expireAt = expireAt;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public Date getExpireAt() {
    return expireAt;
  }

  public void setExpireAt(Date expireAt) {
    this.expireAt = expireAt;
  }
}
