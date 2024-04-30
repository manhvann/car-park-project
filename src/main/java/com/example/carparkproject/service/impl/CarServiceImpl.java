package com.example.carparkproject.service.impl;

import com.example.carparkproject.dto.CarDTO;
import com.example.carparkproject.dto.mapper.CarMapper;
import com.example.carparkproject.dto.mapper.EntityDtoConverter;
import com.example.carparkproject.entity.Car;
import com.example.carparkproject.entity.ParkingLot;
import com.example.carparkproject.repository.CarRepository;
import com.example.carparkproject.repository.ParkingLotRepository;
import com.example.carparkproject.service.CarService;
import com.example.carparkproject.service.ParkingLotService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarMapper carMapper;

    @Autowired
    private ParkingLotService parkingLotService;
    @Autowired
    private ParkingLotRepository parkingLotRepository;
    @PostConstruct
    public void initDB() {
        List<ParkingLot> parkingLots = parkingLotRepository.findAll();
        List<Car> cars = IntStream.rangeClosed(1, 20)
                .mapToObj(i -> {
                    Car car = new Car();
                    car.setLicensePlate(generateLicensePlate()); // Generate random license plate
                    car.setCarColor(generateCarColor()); // Generate random car color
                    car.setCarType("Car Type " + i); // Car type
                    car.setCompany("Company " + i); // Car company
                    car.setParkingLot(parkingLots.get((int)(Math.random() * parkingLots.size())));
                    return car;
                })
                .collect(Collectors.toList());
        carRepository.saveAll(cars);
    }

    private String generateLicensePlate() {
        // Implement your logic to generate a random license plate
        return "ABC" + (int) (Math.random() * 1000);
    }

    private String generateCarColor() {
        // Implement your logic to generate a random car color
        String[] colors = {"Red", "Blue", "Green", "White", "Black"};
        return colors[(int) (Math.random() * colors.length)];
    }
    @Override
    public List<CarDTO> getAllCars() {
        return carRepository.findAll().stream()
                .map(car -> carMapper.toDTO(car))
                .collect(Collectors.toList());
    }

    @Override
    public void addCar(CarDTO carDTO) {
        Car car = carMapper.toEntity(carDTO);
        carRepository.save(car);
    }

    @Override
    public void deleteCar(String licensePlate) {
        carRepository.deleteById(licensePlate);
    }
}
