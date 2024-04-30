package com.example.carparkproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingOfficeDTO {
    private long officeId;
    private String officeName;
    private long tripId;
}
