package com.RentRight.RentRight.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.RentRight.RentRight.dto.LoginInputDTO;
import com.RentRight.RentRight.dto.TokenDTO;
import com.RentRight.RentRight.services.TokenService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody @Valid LoginInputDTO dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(
                dados.getLogin(),
                dados.getPassword());
        var authentication = manager.authenticate(authenticationToken);
        var token = tokenService.generateToken((UserDetails) authentication.getPrincipal());
        var tokenResponse = new TokenDTO(token);
        return new ResponseEntity<TokenDTO>(
                tokenResponse,
                HttpStatus.CREATED);
    }

}