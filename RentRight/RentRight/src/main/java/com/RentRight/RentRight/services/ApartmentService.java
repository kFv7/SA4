package com.RentRight.RentRight.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RentRight.RentRight.dto.ApartmentInputDTO;
import com.RentRight.RentRight.dto.ApartmentOutputDTO;
import com.RentRight.RentRight.entities.Apartment;
import com.RentRight.RentRight.repositories.ApartmentRepository;

import jakarta.transaction.Transactional;

@Service
public class ApartmentService {

    @Autowired
    private ApartmentRepository repository;

    @Transactional
    public ApartmentOutputDTO create(ApartmentInputDTO dto){
        Apartment apartmentCriado = repository.save(converterDtoParaEntidade(dto));
        return converterEntidadeParaDTO(apartmentCriado);
    }

        public ApartmentOutputDTO converterEntidadeParaDTO(Apartment apartment){
        ApartmentOutputDTO dtoSaida = new ApartmentOutputDTO();
        dtoSaida.setId(apartment.getId());
        dtoSaida.setAddress(apartment.getAddress());
        dtoSaida.setRentalPrice(apartment.getRentalPrice());
        dtoSaida.setBathroomNumber(apartment.getBathroomNumber());
        dtoSaida.setBedroomsNumber(apartment.getBedroomsNumber());
        dtoSaida.setSize(apartment.getSize());
        return dtoSaida;
    }

    public Apartment converterDtoParaEntidade(ApartmentInputDTO dto){
        Apartment apartment = new Apartment();
        apartment.setId(apartment.getId());
        apartment.setAddress(apartment.getAddress());
        apartment.setRentalPrice(apartment.getRentalPrice());
        apartment.setBathroomNumber(apartment.getBathroomNumber());
        apartment.setBedroomsNumber(apartment.getBedroomsNumber());
        apartment.setSize(apartment.getSize());
        return apartment;
    }

    public ApartmentOutputDTO read(Long id){
        Apartment apartment = repository.findById(id).get();
        return converterEntidadeParaDTO(apartment);
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
    public ApartmentOutputDTO update(ApartmentInputDTO apartment){
        if(apartment.getId() == null){
            apartment.setId(99l);
        }
        if(repository.existsById(apartment.getId())){
            Apartment apartmentUpdate = repository.save(converterDtoParaEntidade(apartment));
            return converterEntidadeParaDTO(apartmentUpdate);
        }else{
            return null;
        }
    }
}