package com.nhatha.smallroombookingbackend.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Service cannot be booked.")
public class ServiceCannotBeBookedException extends RuntimeException {
}
