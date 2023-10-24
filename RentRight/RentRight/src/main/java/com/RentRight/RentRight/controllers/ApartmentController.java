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

import com.RentRight.RentRight.entities.Apartment;
import com.RentRight.RentRight.services.ApartmentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("Apartments")
public class ApartmentController {
    
    @Autowired
    private ApartmentService service;

    @PostMapping
    public ResponseEntity<Apartment> post(@RequestBody Apartment apartment){
        Apartment apartmentCriado = service.create(apartment);
        return ResponseEntity.ok(apartmentCriado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Apartment> getRead(@PathVariable Long id){
        Apartment apartment = service.read(id);
        return ResponseEntity.ok(apartment);
    }

    @GetMapping
    public ResponseEntity<List<Apartment>> getList(){
        List<Apartment> lista = service.list();
        return ResponseEntity.ok(lista);

    }

    @PutMapping
    public ResponseEntity<Apartment> put(@RequestBody Apartment apartment){
        Apartment apartmentCriado = service.update(apartment);
        return ResponseEntity.ok(apartmentCriado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
