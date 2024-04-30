package com.example.carparkproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "parkinglot")
@Data
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long parkId;

    private long parkArea;
    private String parkName;
    private String parkPlace;
    private double parkPrice;
    private String parkStatus;

    @JsonIgnore
    @OneToMany(mappedBy = "parkingLot",cascade = CascadeType.ALL)
    private Set<Car> cars;
}
