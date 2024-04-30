package com.example.carparkproject.service.impl;

import com.example.carparkproject.dto.BookingOfficeDTO;
import com.example.carparkproject.dto.BookingOfficeRequestDTO;
import com.example.carparkproject.dto.mapper.BookingOfficeRequestMapper;
import com.example.carparkproject.dto.mapper.EntityDtoConverter;
import com.example.carparkproject.entity.BookingOffice;
import com.example.carparkproject.entity.Trip;
import com.example.carparkproject.repository.BookingOfficeRepository;
import com.example.carparkproject.repository.TripRepository;
import com.example.carparkproject.service.BookingOfficeService;
import com.example.carparkproject.service.TripService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class BookingOfficeServiceImpl implements BookingOfficeService {
    @Autowired
    private BookingOfficeRepository bookingOfficeRepository;

    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private EntityDtoConverter entityDtoConverter;
    @Autowired
    private TripService tripService;
    @Autowired
    private BookingOfficeRequestMapper bookingOfficeRequestMapper;

    @PostConstruct
    public void initDB() {
        List<Trip> trips = tripRepository.findAll();
        List<BookingOffice> bookingOffices = IntStream.rangeClosed(1, 20)
                .mapToObj(i -> {
                    BookingOffice bookingOffice = new BookingOffice();
                    bookingOffice.setEndContractDeadline(LocalDate.now().plusDays((int)(Math.random() * i)));
                    bookingOffice.setOfficeName("Office Name " + i);
                    bookingOffice.setOfficePhone("Office Phone " + i);
                    bookingOffice.setOfficePlace("Office Place " + i);
                    bookingOffice.setOfficePrice(i * 1000);
                    bookingOffice.setStartContractDeadline(LocalDate.now().minusDays((int)(Math.random() * i)));
                    // Randomly assign a trip to the booking office
                    bookingOffice.setTripBookingOffice(trips.get((int)(Math.random() * trips.size())));
                    return bookingOffice;
                })
                .collect(Collectors.toList());
        bookingOfficeRepository.saveAll(bookingOffices);
    }

    @Override
    public List<BookingOfficeDTO> viewBookingOfficeList() {
        return bookingOfficeRepository.findAll()
                .stream()
                .map(x->entityDtoConverter.convertToDto(x,BookingOfficeDTO.class))
                .toList();
    }

    @Override
    public void addBookingOffice(BookingOfficeRequestDTO bookingOfficeRequestDTO){
        BookingOffice bookingOffice = bookingOfficeRequestMapper.toEntity(bookingOfficeRequestDTO);
        bookingOfficeRepository.save(bookingOffice);
    }

}
