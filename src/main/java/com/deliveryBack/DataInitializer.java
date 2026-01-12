package com.deliveryBack;

import com.deliveryBack.entity.PackageEntity;
import com.deliveryBack.entity.TrackingEvent;
import com.deliveryBack.enums.PackageStates;
import com.deliveryBack.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private PackageRepository packageRepository;

    @Override
    public void run(String... args) {

        PackageEntity p1 = new PackageEntity(PackageStates.DELIVERED, "Bogotá", "Villavicencio", "Daniel Sanchez", "Batman", LocalDate.now(), 1);
        PackageEntity p2 = new PackageEntity(PackageStates.UNDER_CONSTRUCTION, "Medellín", "Cali", "Pepe cuenca", "Spiderman", LocalDate.of(2025, 6, 27), 6);

        TrackingEvent t1 = new TrackingEvent(PackageStates.UNDER_CONSTRUCTION, "Se ha recibido la orden de paquete", LocalDateTime.now(), p1);

        p1.addTrackingEvent(t1);

        packageRepository.save(p1);
        packageRepository.save(p2);
    }
}
