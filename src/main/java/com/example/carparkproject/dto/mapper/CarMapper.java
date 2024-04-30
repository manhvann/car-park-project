package com.example.carparkproject.dto.mapper;

import com.example.carparkproject.dto.CarDTO;
import com.example.carparkproject.entity.Car;
import com.example.carparkproject.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    @Autowired
    private ParkingLotRepository parkingLotRepository;

    public CarDTO toDTO(Car car){
        CarDTO carDTO = new CarDTO();
        carDTO.setCarColor(car.getCarColor());
        carDTO.setCarType(car.getCarType());
        carDTO.setCompany(car.getCompany());
        carDTO.setLicensePlate(car.getLicensePlate());
        carDTO.setParkingLotId(car.getParkingLot().getParkId());
        return carDTO;
    }

    public Car toEntity(CarDTO carDTO){
        Car car = new Car();
        car.setLicensePlate(carDTO.getLicensePlate());
        car.setCarColor(carDTO.getCarColor());
        car.setCompany(carDTO.getCompany());
        car.setCarType(carDTO.getCarType());
        car.setParkingLot(parkingLotRepository.findById(carDTO.getParkingLotId()).get());
        return car;
    }
}
