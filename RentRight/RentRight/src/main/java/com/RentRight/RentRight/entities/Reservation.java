package com.RentRight.RentRight.entities;

import com.RentRight.RentRight.dto.ReservationInputDTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Reservation {  
    public Reservation(ReservationInputDTO reservationInput){
        this.id = reservationInput.getId();
        this.checkin = reservationInput.getCheckin();
        this.checkout = reservationInput.getCheckout();
        this.reserveStatus = reservationInput.getReserveStatus();
        this.rentalPrice = reservationInput.getRentalPrice();
    }

    @Id @GeneratedValue( strategy = GenerationType.AUTO)

    @NotNull
    private Long id;

    @NotBlank 
    private String checkin;

    @NotBlank 
    private String checkout;

    @NotBlank
    private String reserveStatus;

    @Min(value = 50)
    private Double rentalPrice;

    @ManyToOne
    private User user;
    @ManyToOne
    private Apartment apartment;
}
