package com.ewecarreira.car.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ewecarreira.car.domain.entities.TravelRequest;
import com.ewecarreira.car.domain.enums.TravelRequestStatus;
import com.ewecarreira.car.domain.repositories.TravelRequestRepository;

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
