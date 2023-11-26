package com.RentRight.RentRight.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RentRight.RentRight.dto.ReservationInputDTO;
import com.RentRight.RentRight.dto.ReservationOutputDTO;
import com.RentRight.RentRight.services.ReservationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("reservation")
@CrossOrigin
public class ReservationController {
    
    @Autowired
    private ReservationService service;

    @PostMapping
    public ResponseEntity<ReservationOutputDTO> post(@Valid @RequestBody ReservationInputDTO reservation){
        ReservationOutputDTO reservationCreated = service.create(reservation);
        return new ResponseEntity<ReservationOutputDTO>(reservationCreated, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationOutputDTO> getRead(@Valid @PathVariable Long id){
        ReservationOutputDTO reservationFo = service.read(id);
        return ResponseEntity.ok(reservationFo); // reservationFo == reservationFound
    }

    @GetMapping
    public ResponseEntity<List<ReservationOutputDTO>> getList(Pageable page) {
        List<ReservationOutputDTO> lista = service.list(page);
        return ResponseEntity.ok(lista);
    }

    @PutMapping
    public ResponseEntity<ReservationOutputDTO> put(@Valid @RequestBody ReservationInputDTO reservation){
        ReservationOutputDTO reservationUpdate = service.update(reservation);
        return ResponseEntity.ok(reservationUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@Valid @PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
