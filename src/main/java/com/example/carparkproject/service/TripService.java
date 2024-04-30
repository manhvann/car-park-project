package com.example.carparkproject.service;

import com.example.carparkproject.dto.TripDTO;
import com.example.carparkproject.entity.Trip;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface TripService {
    void addTrip(Trip trip);
    List<TripDTO> viewTripList();
    Page<TripDTO> findTripsByDate(int offset, int pageSize, LocalDate departureDate);
    void delete(long tripId);
}
