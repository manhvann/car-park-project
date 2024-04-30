package com.example.carparkproject.controller;

import com.example.carparkproject.dto.EmployeeDTO;
import com.example.carparkproject.dto.TripDTO;
import com.example.carparkproject.entity.Trip;
import com.example.carparkproject.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class TripController {
    @Autowired
    private TripService tripService;
    @PostMapping("/trip")
    public ResponseEntity<?> addTrip(@RequestBody Trip trip){
        tripService.addTrip(trip);
        return new ResponseEntity<>("Trip added success", HttpStatus.OK);
    }

    @GetMapping("/trip")
    public ResponseEntity<?> getList(){
        return ResponseEntity.ok().body(tripService.viewTripList());
    }

    @GetMapping("/trip/pageAndSortByDate")
    public ResponseEntity<Page<TripDTO>> getListWithPageAndSortByDate(@RequestParam(defaultValue = "0") int offset, @RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "2024-03-30")LocalDate departureDate){
        return ResponseEntity.ok().body(tripService.findTripsByDate(offset,pageSize,departureDate));
    }

    @DeleteMapping("/trip")
    public ResponseEntity<?> delete(@RequestParam long tripId){
        tripService.delete(tripId);
        return new ResponseEntity<>("Trip deleted success",HttpStatus.OK);
    }
}
