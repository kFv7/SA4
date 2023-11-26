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

import com.RentRight.RentRight.dto.ContractInputDTO;
import com.RentRight.RentRight.dto.ContractOutputDTO;
import com.RentRight.RentRight.services.ContractService;
import com.RentRight.RentRight.entities.Contract;

import jakarta.validation.Valid;

@RestController
@RequestMapping("Contract")
@CrossOrigin
public class ContractController {
    
    @Autowired
    private ContractService service;

    @PostMapping
    public ResponseEntity<ContractOutputDTO> post(@Valid @RequestBody ContractInputDTO contract){
        ContractOutputDTO contractCreated = service.create(contract);
        return new ResponseEntity<ContractOutputDTO>(contractCreated, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContractOutputDTO> getRead(@Valid @PathVariable Long id){
        ContractOutputDTO contractFo = service.read(id);
        return ResponseEntity.ok(contractFo); // contractFo == contractFound
    }

    @GetMapping
    public ResponseEntity<List<Contract>> getList(Pageable page) {
        List<Contract> lista = service.list(page);
        return ResponseEntity.ok(lista);
    }

    @PutMapping
    public ResponseEntity<ContractOutputDTO> put(@Valid @RequestBody ContractInputDTO contract){
        ContractOutputDTO contractUpdate = service.update(contract);
        return ResponseEntity.ok(contractUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@Valid @PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
