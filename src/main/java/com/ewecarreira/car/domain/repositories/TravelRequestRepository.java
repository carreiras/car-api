package com.ewecarreira.car.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ewecarreira.car.domain.entities.TravelRequest;

public interface TravelRequestRepository extends JpaRepository<TravelRequest, Long> {
}
