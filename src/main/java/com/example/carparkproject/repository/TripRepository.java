package com.example.carparkproject.repository;

import com.example.carparkproject.dto.TripDTO;
import com.example.carparkproject.entity.Trip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
@Repository
public interface TripRepository extends JpaRepository<Trip,Long>, PagingAndSortingRepository<Trip,Long> {
    Page<Trip> findAllByDepartureDate(LocalDate departureDate, Pageable pageable);
}
