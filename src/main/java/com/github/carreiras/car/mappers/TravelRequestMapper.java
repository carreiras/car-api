package com.github.carreiras.car.mappers;

import com.github.carreiras.car.domain.entities.Passenger;
import com.github.carreiras.car.domain.entities.TravelRequest;
import com.github.carreiras.car.domain.repositories.PassengerRepository;
import com.github.carreiras.car.rest.dtos.TravelRequestInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class TravelRequestMapper {

    @Autowired
    private PassengerRepository passengerRepository;

    public TravelRequest map(TravelRequestInput travelRequestInput) {
        Passenger passenger = passengerRepository.findById(travelRequestInput.getPassengerId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        TravelRequest travelRequest = new TravelRequest();
        travelRequest.setOrigin(travelRequestInput.getOrigin());
        travelRequest.setDestination(travelRequestInput.getDestination());
        travelRequest.setPassenger(passenger);

        return travelRequest;
    }
}
