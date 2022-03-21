package com.github.carreiras.car.domain.entities;

import com.github.carreiras.car.domain.enums.TravelRequestStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class TravelRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    private Passenger passenger;
    private String origin;
    private String destination;

    @Enumerated(EnumType.STRING)
    private TravelRequestStatus status;
    private Date creationDate;
}
