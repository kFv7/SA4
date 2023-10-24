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

import com.RentRight.RentRight.entities.Contract;
import com.RentRight.RentRight.services.ContractService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("Contract")
public class ContractController {
    
    @Autowired
    private ContractService service;

    @PostMapping
    public ResponseEntity<Contract> post(@RequestBody Contract contract){
        Contract contractCriado = service.create(contract);
        return ResponseEntity.ok(contractCriado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contract> getRead(@PathVariable Long id){
        Contract contract = service.read(id);
        return ResponseEntity.ok(contract);
    }

    @GetMapping
    public ResponseEntity<List<Contract>> getList(){
        List<Contract> lista = service.list();
        return ResponseEntity.ok(lista);

    }

    @PutMapping
    public ResponseEntity<Contract> put(@RequestBody Contract contract){
        Contract contractCriado = service.update(contract);
        return ResponseEntity.ok(contractCriado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
