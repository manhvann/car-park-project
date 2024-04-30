package com.example.carparkproject.repository;

import com.example.carparkproject.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car,String>, PagingAndSortingRepository<Car,String> {
}
