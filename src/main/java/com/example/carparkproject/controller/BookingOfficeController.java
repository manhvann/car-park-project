package com.example.carparkproject.controller;

import com.example.carparkproject.dto.BookingOfficeRequestDTO;
import com.example.carparkproject.service.BookingOfficeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BookingOfficeController {

    private final BookingOfficeService bookingOfficeService;

    public BookingOfficeController(BookingOfficeService bookingOfficeService) {
        this.bookingOfficeService = bookingOfficeService;
    }

    @GetMapping("/bookingOffice")
    public ResponseEntity<?> getList(){
        return ResponseEntity.ok().body(bookingOfficeService.viewBookingOfficeList());
    }

    @PostMapping("/bookingOffice")
    public ResponseEntity<?> add(@RequestBody BookingOfficeRequestDTO bookingOfficeRequestDTO){
        bookingOfficeService.addBookingOffice(bookingOfficeRequestDTO);
        return new ResponseEntity<>("BookingOffice added success", HttpStatus.OK);
    }
}
