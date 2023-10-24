package com.RentRight.RentRight.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RentRight.RentRight.entities.Reservation;
import com.RentRight.RentRight.services.ReservationService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("reservation")
public class ReservationController {
    
    @Autowired
    private ReservationService service;

    @PostMapping
    public ResponseEntity<Reservation> post(@RequestBody Reservation reservation){
        Reservation reservationCriado = service.create(reservation);
        return ResponseEntity.ok(reservationCriado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getRead(@PathVariable Long id){
        Reservation reservation = service.read(id);
        return ResponseEntity.ok(reservation);
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getList(){
        List<Reservation> lista = service.list();
        return ResponseEntity.ok(lista);

    }

    @PutMapping
    public ResponseEntity<Reservation> put(@RequestBody Reservation reservation){
        Reservation reservationCriado = service.update(reservation);
        return ResponseEntity.ok(reservationCriado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
