package com.example.carparkproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripDTO {
    private String carType;
    private long bookedTicketNumber;
    private LocalTime departureTime;
    private String destination;
    private String driver;
}
