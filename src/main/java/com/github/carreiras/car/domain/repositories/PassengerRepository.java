package com.github.carreiras.car.domain.repositories;

import com.github.carreiras.car.domain.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
