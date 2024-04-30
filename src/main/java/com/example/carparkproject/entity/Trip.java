package com.example.carparkproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Table(name = "trip")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tripId;

    @Formula("(SELECT COUNT(*) FROM ticket t WHERE t.trip_id = trip_id)")
    private long bookedTicketNumber;
    private String carType;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private String destination;
    private String driver;

    private long maximumOnlineTicketNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "tripBookingOffice",cascade = CascadeType.ALL)
    private Set<BookingOffice> bookingOffices;

    @OneToMany(mappedBy = "tripTicket",cascade = CascadeType.ALL)
    private Set<Ticket> tickets;
}
