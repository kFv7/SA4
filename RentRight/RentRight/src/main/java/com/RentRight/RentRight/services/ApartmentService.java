package com.RentRight.RentRight.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RentRight.RentRight.entities.Apartment;
import com.RentRight.RentRight.repositories.ApartmentRepository;

import jakarta.transaction.Transactional;

@Service
public class ApartmentService {

    @Autowired
    private ApartmentRepository repository;

    @Transactional
    public Apartment create(Apartment apartment){
        Apartment apartmentCriado = repository.save(apartment);
        return apartmentCriado;
    }

    public Apartment read(Long id){
        return repository.findById(id).get();
    }

    public List<Apartment> list(){
        List<Apartment> apartments = (List<Apartment>) repository.findAll();
        return apartments;
    }

    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }

    @Transactional
    public Apartment update(Apartment apartment){
        if(repository.existsById(apartment.getId())){
            return repository.save(apartment);
        }else{
            return null;
        }
    }
}