package com.RentRight.RentRight.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.RentRight.RentRight.dto.ReservationInputDTO;
import com.RentRight.RentRight.dto.ReservationOutputDTO;
import com.RentRight.RentRight.entities.Reservation;
import com.RentRight.RentRight.repositories.ReservationRepository;

import jakarta.transaction.Transactional;

@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository repository;

    @Transactional
    public ReservationOutputDTO create(ReservationInputDTO dto){
        Reservation reservationCriado = repository.save(converterDtoParaEntidade(dto));
        return converterEntidadeParaDTO(reservationCriado);
    }

    public ReservationOutputDTO converterEntidadeParaDTO(Reservation reservation){
        ReservationOutputDTO dtoSaida = new ReservationOutputDTO();
        dtoSaida.setId(reservation.getId());
        dtoSaida.setCheckin(reservation.getCheckin());
        dtoSaida.setCheckout(reservation.getCheckout());
        dtoSaida.setRentalPrice(reservation.getRentalPrice());
        dtoSaida.setReserveStatus(reservation.getReserveStatus());
        return dtoSaida;
    }

    public Reservation converterDtoParaEntidade(ReservationInputDTO dto){
        Reservation reservation = new Reservation();
        reservation.setId(reservation.getId());
        reservation.setCheckin(reservation.getCheckin());
        reservation.setCheckout(reservation.getCheckout());
        reservation.setRentalPrice(reservation.getRentalPrice());
        reservation.setReserveStatus(reservation.getReserveStatus());
        return reservation;
    }

    public ReservationOutputDTO read(Long id){
        Reservation reservation = repository.findById(id).get();
        return converterEntidadeParaDTO(reservation);
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
    public ReservationOutputDTO update(ReservationInputDTO reservation){
        if(reservation.getId() == null){
            reservation.setId(99l);
        }
        if(repository.existsById(reservation.getId())){
            Reservation reservationUpdate = repository.save(converterDtoParaEntidade(reservation));
            return converterEntidadeParaDTO(reservationUpdate);
        }else{
            return null;
        }
    }

    public List<ReservationOutputDTO> list(Pageable page) {
        return null;
    } 
}