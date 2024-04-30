package com.example.carparkproject.repository;

import com.example.carparkproject.entity.BookingOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingOfficeRepository extends JpaRepository<BookingOffice,Long>, PagingAndSortingRepository<BookingOffice,Long> {
}
