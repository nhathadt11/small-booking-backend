package com.nhatha.smallroombookingbackend.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Room not found or not available.")
public class RoomNotFoundOrNotAvailableException extends RuntimeException {
}
