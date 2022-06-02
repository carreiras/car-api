package com.ewecarreira.car.rest.dtos;

import java.util.Date;

import org.springframework.hateoas.RepresentationModel;

import com.ewecarreira.car.domain.enums.TravelRequestStatus;

import lombok.Data;

@Data
public class TravelRequestOutput extends RepresentationModel<TravelRequestOutput> {

    Long id;
    String origin;
    String destination;
    TravelRequestStatus status;
    Date creationDate;
}
