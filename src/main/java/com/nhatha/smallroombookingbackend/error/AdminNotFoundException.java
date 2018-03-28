package com.nhatha.smallroombookingbackend.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Admin could not be found.")
public class AdminNotFoundException extends RuntimeException {
}
