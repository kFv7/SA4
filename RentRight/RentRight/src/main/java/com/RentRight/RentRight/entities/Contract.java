package com.RentRight.RentRight.entities;

import java.sql.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.*;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Contract {
    @Id @GeneratedValue( strategy = GenerationType.AUTO)

    @NotNull
    private Long id;

    @NotBlank @Past
    private Date startDate;

    @NotBlank @Past
    private Date endDate;

    @ManyToOne
    private User user;
    @ManyToOne
    private Apartment apartment;
}