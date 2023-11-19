package com.RentRight.RentRight.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class LoginInputDTO {
    
    @NotBlank
    private String login;

    @NotBlank
    private String password;
}
