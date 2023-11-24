package com.RentRight.RentRight.entities;


import com.RentRight.RentRight.dto.ContractInputDTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.*;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity 
public class Contract {
    public Contract(ContractInputDTO contractInput) {
        this.id = contractInput.getId();
        this.startDate = contractInput.getStartDate();
        this.endDate = contractInput.getEndDate();
    }
    
    @Id @GeneratedValue( strategy = GenerationType.AUTO)

    @NotNull
    private Long id;

    @NotBlank @Past
    private String startDate;

    @NotBlank @Past
    private String endDate;

    @ManyToOne
    private User user;
    @ManyToOne
    private Apartment apartment;
}