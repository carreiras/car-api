package com.ewecarreira.car.rest.dtos;

import lombok.Data;

@Data
public class TravelRequestInput {

    Long passengerId;
    String origin;
    String destination;
}
