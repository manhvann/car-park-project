package com.example.carparkproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingOfficeRequestDTO {
    private LocalDate endContractDeadline;
    private String officeName;
    private String officePhone;
    private String officePlace;
    private long officePrice;
    private LocalDate startContractDeadline;
    private long tripId;
}
