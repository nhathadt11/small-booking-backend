package com.nhatha.smallroombookingbackend.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Service booking could not be found.")
public class ServiceBookingNotFoundException extends RuntimeException {
}
