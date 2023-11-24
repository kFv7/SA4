package com.RentRight.RentRight;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.RentRight.RentRight.dto.ReservationInputDTO;
import com.RentRight.RentRight.dto.ReservationOutputDTO;
import com.RentRight.RentRight.entities.Reservation;
import com.RentRight.RentRight.repositories.ReservationRepository;
import com.RentRight.RentRight.services.ReservationService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ReservationRegisterTest {
    
    @InjectMocks
    private ReservationService service;

    @Mock
    private ReservationRepository repository;

    @Test
    void registerReservation() {

        ReservationInputDTO reservationInput = new ReservationInputDTO(1l, "21/09/23", "23/09/23", "Ativo", 400.99);

        Reservation reservation = new Reservation(reservationInput); 
        
        when(repository.existsById(anyLong())).thenReturn(true);
        when(repository.save(any())).thenReturn(reservation);

        ReservationOutputDTO reservationAtualizado = service.update(reservationInput);

        assertEquals(reservationInput.getId(), reservationAtualizado.getId());
        assertEquals(reservationInput.getCheckin(), reservationAtualizado.getCheckin());
        assertEquals(reservationInput.getCheckout(), reservationAtualizado.getCheckout());
        assertEquals(reservationInput.getReserveStatus(), reservationAtualizado.getReserveStatus());
        assertEquals(reservationInput.getRentalPrice(), reservationAtualizado.getRentalPrice());

    }
}
