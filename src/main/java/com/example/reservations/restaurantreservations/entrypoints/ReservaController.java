package com.example.reservations.restaurantreservations.entrypoints;

import com.example.reservations.restaurantreservations.domain.Reserva;
import com.example.reservations.restaurantreservations.drivers.ReservaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservaController {
    private final ReservaRepository reservaRepository;

    ReservaController(ReservaRepository repository) {
        this.reservaRepository  = repository;
    }

    @GetMapping("/reservas")
    List<Reserva> getReservas() {
        return reservaRepository.findAll();
    }

    @PostMapping("/reservar")
    Reserva guardarReserva(@RequestBody Reserva reserva){
        return reservaRepository.save(reserva);
    }

    @PutMapping
    Reserva replaceEmployee(@RequestBody Reserva nuevaReserva, @PathVariable Long id) {

        return reservaRepository.findById(id)
                .map(reserva -> {
                    reserva.setNombre(nuevaReserva.getNombre());
                    reserva.setComensales(nuevaReserva.getComensales());
                    reserva.setObservaciones(nuevaReserva.getObservaciones());
                    reserva.setDniComensal(nuevaReserva.getDniComensal());
                    reserva.setTipoDni(nuevaReserva.getTipoDni());
                    return reservaRepository.save(reserva);
                })
                .orElseGet(() -> {
                    nuevaReserva.setIdReserva(id);
                    return reservaRepository.save(nuevaReserva);
                });
    }

}
