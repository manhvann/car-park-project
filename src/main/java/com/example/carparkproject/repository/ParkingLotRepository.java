package com.example.carparkproject.repository;

import com.example.carparkproject.entity.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot,Long>, PagingAndSortingRepository<ParkingLot,Long> {
}
