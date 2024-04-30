package com.example.carparkproject.service.impl;

import com.example.carparkproject.dto.EmployeeDTO;
import com.example.carparkproject.dto.TripDTO;
import com.example.carparkproject.dto.mapper.EntityDtoConverter;
import com.example.carparkproject.entity.Trip;
import com.example.carparkproject.repository.TripRepository;
import com.example.carparkproject.service.TripService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class TripServiceImpl implements TripService {
    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private EntityDtoConverter entityDtoConverter;

    @PostConstruct
    public void initDB() {
        List<Trip> trips = IntStream.rangeClosed(1, 20)
                .mapToObj(i -> {
                    Trip trip = new Trip();
                    trip.setCarType("Car Type " + i);
                    trip.setDepartureDate(LocalDate.now().plusDays((int)(Math.random() * i)));
                    trip.setDepartureTime(LocalTime.now().plusHours(i));
                    trip.setDestination("Destination " + i);
                    trip.setDriver("Driver " + i);
                    trip.setMaximumOnlineTicketNumber(i * 10);
                    return trip;
                })
                .collect(Collectors.toList());
        tripRepository.saveAll(trips);
    }
    @Override
    public void addTrip(Trip trip){
        tripRepository.save(trip);
    }

    @Override
    public List<TripDTO> viewTripList() {
        return tripRepository.findAll()
                .stream()
                .map(x->entityDtoConverter.convertToDto(x,TripDTO.class))
                .toList();
    }

    @Override
    public Page<TripDTO> findTripsByDate(int offset, int pageSize,LocalDate departureDate) {
        Sort sort = Sort.by(Sort.Direction.ASC, "departureTime");

        return tripRepository.findAllByDepartureDate(departureDate, PageRequest.of(offset, pageSize, sort))
                .map(x->entityDtoConverter.convertToDto(x, TripDTO.class));
    }

    @Override
    public void delete(long tripId) {
        tripRepository.delete(tripRepository.findById(tripId).get());
    }
}
