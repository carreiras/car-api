package com.ewecarreira.car.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ewecarreira.car.domain.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
