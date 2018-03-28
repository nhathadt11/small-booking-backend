package com.nhatha.smallroombookingbackend.config.security;

public final class AuthenticationContants {
  private AuthenticationContants() {
  }

  public static final long EXPIRATION_TIME = 864_000_000;
  public static final String HEADER_STRING = "Authorization";
  public static final String TOKEN_PREFIX = "Bearer ";
  public static final String SECRET = "s3cr3t";
  public static final String SIGN_UP_URL = "/admins";
  public static final String UNAUTHENTICATED_USER_URL = "/users/**";
}
