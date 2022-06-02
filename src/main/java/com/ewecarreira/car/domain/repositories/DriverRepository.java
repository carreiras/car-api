package com.ewecarreira.car.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ewecarreira.car.domain.entities.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
