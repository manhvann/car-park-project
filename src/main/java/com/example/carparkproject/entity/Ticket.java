package com.example.carparkproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Table(name = "ticket")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ticketId;

    private LocalTime bookingTime;
    private String customerName;

    @ManyToOne
    @JoinColumn(name = "license_plate",nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "trip_id",nullable = false)
    private Trip tripTicket;
}
