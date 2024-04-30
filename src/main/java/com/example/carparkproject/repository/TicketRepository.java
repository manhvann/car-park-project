package com.example.carparkproject.repository;

import com.example.carparkproject.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long>, PagingAndSortingRepository<Ticket,Long> {
}
