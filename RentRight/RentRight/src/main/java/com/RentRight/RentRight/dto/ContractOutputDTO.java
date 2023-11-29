package com.RentRight.RentRight.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ContractOutputDTO {
    
    private Long id;
    private String startDate;
    private String endDate;
}

