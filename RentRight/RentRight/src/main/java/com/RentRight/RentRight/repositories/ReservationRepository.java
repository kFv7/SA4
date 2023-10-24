package com.RentRight.RentRight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RentRight.RentRight.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    
}
