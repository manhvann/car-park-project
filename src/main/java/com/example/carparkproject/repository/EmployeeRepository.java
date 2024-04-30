package com.example.carparkproject.repository;

import com.example.carparkproject.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>, PagingAndSortingRepository<Employee,Long> {
//    @Query("SELECT e FROM Employee e WHERE e.employeeBirthday BETWEEN :startDate AND :endDate")
    Page<Employee> findByEmployeeBirthdayBetween(LocalDate startDate, LocalDate endDate, Pageable pageable);
}
