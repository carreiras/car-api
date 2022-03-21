package com.github.carreiras.car.domain.repositories;

import com.github.carreiras.car.domain.entities.TravelRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelRequestRepository extends JpaRepository<TravelRequest, Long> {
}
