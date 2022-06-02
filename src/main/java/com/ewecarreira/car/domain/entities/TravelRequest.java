package com.ewecarreira.car.domain.entities;

import lombok.Data;

import javax.persistence.*;

import com.ewecarreira.car.domain.enums.TravelRequestStatus;

import java.util.Date;

@Data
@Entity
public class TravelRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Passenger passenger;
    private String origin;
    private String destination;

    @Enumerated(EnumType.STRING)
    private TravelRequestStatus status;
    private Date creationDate;
}
