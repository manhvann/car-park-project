package com.example.carparkproject.dto.mapper;

import com.example.carparkproject.dto.TickerDTO;
import com.example.carparkproject.entity.Ticket;
import com.example.carparkproject.repository.CarRepository;
import com.example.carparkproject.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {
    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private CarRepository carRepository;
    public TickerDTO toDTO(Ticket ticket){
        TickerDTO tickerDTO =new TickerDTO();
        tickerDTO.setLicensePlate(ticket.getCar().getLicensePlate());
        tickerDTO.setCustomerName(ticket.getCustomerName());
        tickerDTO.setBookingTime(ticket.getBookingTime());
        tickerDTO.setTripId(ticket.getTripTicket().getTripId());
        return tickerDTO;
    }

    public Ticket toEntity(TickerDTO tickerDTO){
        Ticket ticket = new Ticket();
        ticket.setCustomerName(tickerDTO.getCustomerName());
        ticket.setBookingTime(tickerDTO.getBookingTime());
        ticket.setTripTicket(tripRepository.findById(tickerDTO.getTripId()).get());
        ticket.setCar(carRepository.findById(tickerDTO.getLicensePlate()).get());
        return ticket;
    }
}
