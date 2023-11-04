package com.RentRight.RentRight.entities;

import java.sql.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Reservation {
    @Id @GeneratedValue( strategy = GenerationType.AUTO)

    @NotNull
    private Long id;

    @NotBlank 
    private Date checkin;

    @NotBlank 
    private Date checkout;

    @NotBlank
    private String reserveStatus;

    @Min(value = 50)
    private Double rentalPrice;

    @ManyToOne
    private User user;
    @ManyToOne
    private Apartment apartment;
}
