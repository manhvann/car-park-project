package com.example.carparkproject.dto;

import com.example.carparkproject.entity.Car;
import com.example.carparkproject.entity.Trip;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TickerDTO {
    private LocalTime bookingTime;
    private String customerName;
    private String licensePlate;
    private long tripId;
}
