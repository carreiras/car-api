package com.github.carreiras.car.rest.dtos;

import com.github.carreiras.car.domain.enums.TravelRequestStatus;
import lombok.Data;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

@Data
public class TravelRequestOutput extends RepresentationModel<TravelRequestOutput> {

    Long id;
    String origin;
    String destination;
    TravelRequestStatus status;
    Date creationDate;
}
