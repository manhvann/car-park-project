package com.example.carparkproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "car")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    private String licensePlate;

    private String carColor;
    private String carType;
    private String company;

    @OneToMany(mappedBy = "car")
    private Set<Ticket> tickets;

    @ManyToOne
    @JoinColumn(name = "park_id",nullable = false)
    private ParkingLot parkingLot;
}
