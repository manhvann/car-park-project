package com.example.carparkproject.service;

import com.example.carparkproject.dto.CarDTO;

import java.util.List;

public interface CarService {
    List<CarDTO> getAllCars();
    void addCar(CarDTO carDTO);
    void deleteCar(String licensePlate);
}
