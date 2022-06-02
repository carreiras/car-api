package com.ewecarreira.car.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.ewecarreira.car.domain.entities.Driver;
import com.ewecarreira.car.domain.repositories.DriverRepository;

import java.util.List;
import java.util.Optional;

@Service
@RestController
@RequestMapping(value = "/drivers", produces = MediaType.APPLICATION_JSON_VALUE)
public class DriverController {

    @Autowired
    private DriverRepository driverRepository;

    @PostMapping
    public Driver createDriver(@RequestBody Driver driver) {
        return driverRepository.save(driver);
    }

    @PutMapping("/{id}")
    public Driver fullUpdateDriver(@PathVariable("id") Long id, @RequestBody Driver driver) {
        Driver foundDriver = findDriver(id);
        foundDriver.setBirthDate(driver.getBirthDate());
        foundDriver.setName(driver.getName());
        return driverRepository.save(foundDriver);
    }

    @PatchMapping("/{id}")
    public Driver incrementalUpdateDriver(@PathVariable("id") Long id, @RequestBody Driver driver) {
        Driver foundDriver = findDriver(id);
        foundDriver.setBirthDate(
                Optional.ofNullable(driver.getBirthDate())
                        .orElse(foundDriver.getBirthDate()));
        foundDriver.setName(
                Optional.ofNullable(driver.getName())
                        .orElse(foundDriver.getName()));
        return driverRepository.save(foundDriver);
    }

    @DeleteMapping("/{id}")
    public void deleteDriver(@PathVariable("id") Long id) {
        driverRepository.delete(findDriver(id));
    }

    @GetMapping
    public List<Driver> listDrivers() {
        return driverRepository.findAll();
    }

    @GetMapping("/{id}")
    public Driver findDriver(@PathVariable("id") Long id) {
        return driverRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
