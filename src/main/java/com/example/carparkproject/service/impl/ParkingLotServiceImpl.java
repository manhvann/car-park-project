package com.example.carparkproject.service.impl;

import com.example.carparkproject.dto.BookingOfficeDTO;
import com.example.carparkproject.entity.BookingOffice;
import com.example.carparkproject.entity.ParkingLot;
import com.example.carparkproject.repository.ParkingLotRepository;
import com.example.carparkproject.service.ParkingLotService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {
    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @PostConstruct
    public void initDB() {
        List<ParkingLot> parkingLots = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> {
                    ParkingLot parkingLot = new ParkingLot();
                    parkingLot.setParkArea((long) (Math.random() * 1000));
                    parkingLot.setParkName("Parking Lot " + i);
                    parkingLot.setParkPlace("Place " + i);

                    double randomPrice = Math.random() * 100;
                    String formattedPrice = String.format("%.2f", randomPrice);
                    parkingLot.setParkPrice(Double.parseDouble(formattedPrice));

                    parkingLot.setParkStatus("Available");
                    return parkingLot;
                })
                .collect(Collectors.toList());
        parkingLotRepository.saveAll(parkingLots);
    }

    @Override
    public List<ParkingLot> viewParrkingLotList() {
        return parkingLotRepository.findAll();
    }

}
