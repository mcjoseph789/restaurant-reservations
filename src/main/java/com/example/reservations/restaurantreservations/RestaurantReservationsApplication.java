package com.example.reservations.restaurantreservations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.reservations.restaurantreservations.*")
public class RestaurantReservationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantReservationsApplication.class, args);
	}

}
