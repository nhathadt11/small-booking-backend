package com.nhatha.smallroombookingbackend.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_GATEWAY, reason = "Room cannot be found.")
public class RoomNotFoundException extends RuntimeException {

}
