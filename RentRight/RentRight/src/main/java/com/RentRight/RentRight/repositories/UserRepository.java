package com.RentRight.RentRight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RentRight.RentRight.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
    public User findByEmail(String email);
}
