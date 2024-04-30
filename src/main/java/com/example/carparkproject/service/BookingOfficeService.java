package com.example.carparkproject.service;

import com.example.carparkproject.dto.BookingOfficeDTO;
import com.example.carparkproject.dto.BookingOfficeRequestDTO;

import java.util.List;

public interface BookingOfficeService {
    List<BookingOfficeDTO> viewBookingOfficeList();
    void addBookingOffice(BookingOfficeRequestDTO bookingOfficeRequestDTO);
}
