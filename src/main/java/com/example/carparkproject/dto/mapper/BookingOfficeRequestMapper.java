package com.example.carparkproject.dto.mapper;

import com.example.carparkproject.dto.BookingOfficeDTO;
import com.example.carparkproject.dto.BookingOfficeRequestDTO;
import com.example.carparkproject.entity.BookingOffice;
import com.example.carparkproject.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingOfficeRequestMapper {
    @Autowired
    private TripRepository tripRepository;

    public BookingOffice toEntity(BookingOfficeRequestDTO bookingOfficeRequestDTO){
        BookingOffice bookingOffice = new BookingOffice();
        bookingOffice.setOfficeName(bookingOfficeRequestDTO.getOfficeName());
        bookingOffice.setOfficePhone(bookingOfficeRequestDTO.getOfficePhone());
        bookingOffice.setOfficePlace(bookingOfficeRequestDTO.getOfficePlace());
        bookingOffice.setOfficePrice(bookingOfficeRequestDTO.getOfficePrice());
        bookingOffice.setStartContractDeadline(bookingOfficeRequestDTO.getStartContractDeadline());
        bookingOffice.setEndContractDeadline(bookingOfficeRequestDTO.getEndContractDeadline());
        bookingOffice.setTripBookingOffice(tripRepository.findById(bookingOfficeRequestDTO.getTripId()).get());
        return bookingOffice;
    }
}
