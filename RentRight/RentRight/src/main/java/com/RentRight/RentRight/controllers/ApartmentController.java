package com.RentRight.RentRight.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RentRight.RentRight.dto.ApartmentInputDTO;
import com.RentRight.RentRight.dto.ApartmentOutputDTO;
import com.RentRight.RentRight.entities.Apartment;
import com.RentRight.RentRight.services.ApartmentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/apartments")
@CrossOrigin
public class ApartmentController {
    
    @Autowired
    private ApartmentService service;

    @PostMapping
    public ResponseEntity<ApartmentOutputDTO> post(@Valid @RequestBody ApartmentInputDTO apartment){
        ApartmentOutputDTO apartmentCreated = service.create(apartment);
        return new ResponseEntity<ApartmentOutputDTO>(apartmentCreated, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApartmentOutputDTO> getRead(@Valid @PathVariable Long id){
        ApartmentOutputDTO apartmentFo = service.read(id);
        return ResponseEntity.ok(apartmentFo);
    }

    @GetMapping
    public ResponseEntity<List<Apartment>> getList(){
        List<Apartment> lista = service.list();
        return ResponseEntity.ok(lista);

    }

    @PutMapping
    public ResponseEntity<ApartmentOutputDTO> put(@Valid @RequestBody ApartmentInputDTO apartment){
        ApartmentOutputDTO apartmentUpdate = service.update(apartment);
        return ResponseEntity.ok(apartmentUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@Valid @PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
