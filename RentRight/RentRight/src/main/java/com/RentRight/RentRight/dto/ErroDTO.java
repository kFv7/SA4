package com.RentRight.RentRight.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ErroDTO {
    
    private String field;
    private String error;
}
