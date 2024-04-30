package com.example.carparkproject.dto;

import com.example.carparkproject.entity.ParkingLot;
import com.example.carparkproject.entity.Ticket;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {
    private String licensePlate;
    private String carColor;
    private String carType;
    private String company;
    private long parkingLotId;
}
