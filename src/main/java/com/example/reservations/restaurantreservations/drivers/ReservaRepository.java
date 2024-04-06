package com.example.reservations.restaurantreservations.drivers;

import com.example.reservations.restaurantreservations.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, String> {
}

