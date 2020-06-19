package com.project.dev.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.dev.models.Ticket;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, String>{
	//Page<Ticket> findTicketbyEmpId(String empid, Pageable pageable);
	//Optional<Ticket> findByIdAndUserId(String ticketId, String empid);
}