package com.example.carparkproject.service.impl;

import com.example.carparkproject.dto.CarDTO;
import com.example.carparkproject.dto.TickerDTO;
import com.example.carparkproject.dto.mapper.TicketMapper;
import com.example.carparkproject.entity.Car;
import com.example.carparkproject.entity.Ticket;
import com.example.carparkproject.entity.Trip;
import com.example.carparkproject.repository.CarRepository;
import com.example.carparkproject.repository.TicketRepository;
import com.example.carparkproject.repository.TripRepository;
import com.example.carparkproject.service.TicketService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketMapper ticketMapper;

    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private CarRepository carRepository;

    @PostConstruct
    public void initDB() {
        List<Car> cars = carRepository.findAll();
        List<Trip> trips = tripRepository.findAll();

        List<Ticket> tickets = IntStream.rangeClosed(1, 20)
                .mapToObj(i -> {
                    Ticket ticket = new Ticket();
                    ticket.setBookingTime(LocalTime.now()); // Set current booking time
                    ticket.setCustomerName("Customer " + i); // Set customer name
                    // Set random car and trip for ticket
                    ticket.setCar(cars.get((int) (Math.random() * cars.size())));
                    ticket.setTripTicket(trips.get((int) (Math.random() * trips.size())));
                    return ticket;
                })
                .collect(Collectors.toList());
        ticketRepository.saveAll(tickets);
    }

    @Override
    public List<TickerDTO> getAllTickets() {
        return ticketRepository.findAll().stream()
                .map(ticket -> ticketMapper.toDTO(ticket))
                .collect(Collectors.toList());
    }

}
