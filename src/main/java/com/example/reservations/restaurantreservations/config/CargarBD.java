package com.example.reservations.restaurantreservations.config;

import com.example.reservations.restaurantreservations.domain.Reserva;
import com.example.reservations.restaurantreservations.drivers.ReservaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class CargarBD {

    private static final Logger log = LoggerFactory.getLogger(CargarBD.class);

    @Bean
    CommandLineRunner initDatabase(ReservaRepository repository) {
        System.out.println("intiDatabase");
        return args -> {
            log.info("Preloading " + repository.save(new Reserva(1L,"ANDRES","C","1010",5,"NADA","10/10/10 15:00:00")));
        };
    }
}
