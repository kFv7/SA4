package com.RentRight.RentRight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RentRight.RentRight.entities.Contract;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    
}

