package com.example.carparkproject.controller;

import com.example.carparkproject.dto.CarDTO;
import com.example.carparkproject.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/car")
    public ResponseEntity<List<CarDTO>> getList() {
        List<CarDTO> cars = carService.getAllCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }
}
