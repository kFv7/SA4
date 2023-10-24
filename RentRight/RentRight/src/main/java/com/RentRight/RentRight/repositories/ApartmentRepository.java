package com.RentRight.RentRight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RentRight.RentRight.entities.Apartment;


public interface ApartmentRepository extends JpaRepository<Apartment, Long>{
    
}
