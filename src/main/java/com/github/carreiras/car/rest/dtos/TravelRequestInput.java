package com.github.carreiras.car.rest.dtos;

import com.github.carreiras.car.domain.entities.Passenger;
import lombok.Data;

@Data
public class TravelRequestInput {

    private Long passengerId;
    private String origin;
    private String destination;
}
