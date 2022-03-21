package com.github.carreiras.car.rest.controllers;

import com.github.carreiras.car.domain.entities.TravelRequest;
import com.github.carreiras.car.mappers.TravelRequestMapper;
import com.github.carreiras.car.rest.dtos.TravelRequestInput;
import com.github.carreiras.car.services.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
@RequestMapping(value = "/travelRequests", produces = MediaType.APPLICATION_JSON_VALUE)
public class TravelRequestController {

    @Autowired
    private TravelService travelService;

    @Autowired
    private TravelRequestMapper travelRequestMapper;

    @PostMapping
    public TravelRequest makeTravelRequest(@RequestBody TravelRequestInput travelRequestInput) {
        return travelService.saveTravelRequest(travelRequestMapper.map(travelRequestInput));
    }
/*
    @PutMapping("/{id}")
    public Passenger fullUpdatePassenger(@PathVariable("id") Long id, @RequestBody Passenger passenger) {
        Passenger foundPassenger = findPassenger(id);
        foundPassenger.setName(passenger.getName());
        return passengerRepository.save(foundPassenger);
    }

    @PatchMapping("/{id}")
    public Passenger incrementalUpdatePassenger(@PathVariable("id") Long id, @RequestBody Passenger Passenger) {
        Passenger foundPassenger = findPassenger(id);
        foundPassenger.setName(
                Optional.ofNullable(Passenger.getName())
                        .orElse(foundPassenger.getName()));
        return passengerRepository.save(foundPassenger);
    }

    @DeleteMapping("/{id}")
    public void deletePassenger(@PathVariable("id") Long id) {
        passengerRepository.delete(findPassenger(id));
    }

    @GetMapping
    public List<Passenger> listPassengers() {
        return passengerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Passenger findPassenger(@PathVariable("id") Long id) {
        return passengerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
 */
}
