package com.RentRight.RentRight.dto;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ContractInputDTO {
    @NotNull
    private Long id;

    @NotBlank @Past
    private Date startDate;

    @NotBlank @Past
    private Date endDate;
}
