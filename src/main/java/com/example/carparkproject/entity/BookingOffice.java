package com.example.carparkproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "bookingoffice")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long officeId;

    private LocalDate endContractDeadline;
    private String officeName;
    private String officePhone;
    private String officePlace;
    private long officePrice;
    private LocalDate startContractDeadline;


    @ManyToOne
    @JoinColumn(name = "trip_Id", referencedColumnName = "tripId")
    private Trip tripBookingOffice;
}
