package com.RentRight.RentRight.entities;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.*;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Reservation {
    @Id @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;
    private Date checkin;
    private Date checkout;
    private String reserveStatus;
    private Double rentalPrice;

    @ManyToOne
    private User user;
    @ManyToOne
    private Apartment apartment;
}
