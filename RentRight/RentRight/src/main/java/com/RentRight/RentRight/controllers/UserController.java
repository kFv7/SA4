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

import com.RentRight.RentRight.entities.User;
import com.RentRight.RentRight.services.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {
    
    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<User> post(@Valid @RequestBody User user){
        User userCriado = service.create(user);
        return ResponseEntity.ok(userCriado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getRead(@Valid @PathVariable Long id){
        User user = service.read(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getList(){
        List<User> lista = service.list();
        return ResponseEntity.ok(lista);

    }

    @PutMapping
    public ResponseEntity<User> put(@Valid @RequestBody User user){
        User userCriado = service.update(user);
        return ResponseEntity.ok(userCriado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@Valid @PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
