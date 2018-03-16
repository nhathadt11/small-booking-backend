package com.nhatha.smallroombookingbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.nhatha.smallroombookingbackend.persistance.repository")
@EntityScan("com.nhatha.smallroombookingbackend.persistance.model")
@SpringBootApplication
public class SmallRoomBookingBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmallRoomBookingBackendApplication.class, args);
	}
}
