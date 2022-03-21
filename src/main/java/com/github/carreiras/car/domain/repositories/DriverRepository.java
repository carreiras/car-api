package com.github.carreiras.car.domain.repositories;

import com.github.carreiras.car.domain.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
