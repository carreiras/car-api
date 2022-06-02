package com.ewecarreira.car.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.ewecarreira.car.domain.entities.Passenger;
import com.ewecarreira.car.domain.entities.TravelRequest;
import com.ewecarreira.car.domain.repositories.PassengerRepository;
import com.ewecarreira.car.rest.controllers.PassengerController;
import com.ewecarreira.car.rest.dtos.TravelRequestInput;
import com.ewecarreira.car.rest.dtos.TravelRequestOutput;

@Component
public class TravelRequestMapper {

    @Autowired
    private PassengerRepository passengerRepository;

    public TravelRequest map(TravelRequestInput input) {
        Passenger passenger = passengerRepository.findById(input.getPassengerId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        TravelRequest travelRequest = new TravelRequest();
        travelRequest.setOrigin(input.getOrigin());
        travelRequest.setDestination(input.getDestination());
        travelRequest.setPassenger(passenger);
        return travelRequest;
    }

    public TravelRequestOutput map(TravelRequest travelRequest) {
        TravelRequestOutput travelRequestOutput = new TravelRequestOutput();
        travelRequestOutput.setId(travelRequest.getId());
        travelRequestOutput.setOrigin(travelRequest.getOrigin());
        travelRequestOutput.setDestination(travelRequest.getDestination());
        travelRequestOutput.setCreationDate(travelRequest.getCreationDate());
        travelRequestOutput.setStatus(travelRequest.getStatus());
        return travelRequestOutput;
    }

    public EntityModel<TravelRequestOutput> buildOutputModel(TravelRequest travelRequest, TravelRequestOutput output) {
        EntityModel<TravelRequestOutput> model = new EntityModel<>(output);
        Link passengerLink = WebMvcLinkBuilder
                .linkTo(PassengerController.class)
                .slash(travelRequest.getPassenger().getId())
                .withRel("passenger")
                .withTitle(travelRequest.getPassenger().getName());
        model.add(passengerLink);
        return model;
    }
}
