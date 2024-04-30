package com.example.carparkproject.controller;

import com.example.carparkproject.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ParkingLotController {
    @Autowired
    private ParkingLotService parkingLotService;
    @GetMapping("/parkingLot")
    public ResponseEntity<?> getList(){
        return ResponseEntity.ok().body(parkingLotService.viewParrkingLotList());
    }
}
