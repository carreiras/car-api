package com.github.carreiras.car.services;

import com.github.carreiras.car.domain.entities.TravelRequest;
import com.github.carreiras.car.domain.enums.TravelRequestStatus;
import com.github.carreiras.car.domain.repositories.TravelRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TravelService {

    @Autowired
    private TravelRequestRepository travelRequestRepository;

    public TravelRequest saveTravelRequest(TravelRequest travelRequest) {
        travelRequest.setStatus(TravelRequestStatus.CREATED);
        travelRequest.setCreationDate(new Date());
        
        return travelRequestRepository.save(travelRequest);
    }
}
