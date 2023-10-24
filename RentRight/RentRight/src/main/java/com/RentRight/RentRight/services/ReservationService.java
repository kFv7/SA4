package com.RentRight.RentRight.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RentRight.RentRight.entities.Reservation;
import com.RentRight.RentRight.repositories.ReservationRepository;

import jakarta.transaction.Transactional;

@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository repository;

    @Transactional
    public Reservation create(Reservation reservation){
        Reservation reservationCriado = repository.save(reservation);
        return reservationCriado;
    }

    public Reservation read(Long id){
        return repository.findById(id).get();
    }

    public List<Reservation> list(){
        List<Reservation> reservations = (List<Reservation>) repository.findAll();
        return reservations;
    }

    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }

    @Transactional
    public Reservation update(Reservation reservation){
        if(repository.existsById(reservation.getId())){
            return repository.save(reservation);
        }else{
            return null;
        }
    }
}

