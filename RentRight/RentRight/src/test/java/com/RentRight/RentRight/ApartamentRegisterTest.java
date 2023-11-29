package com.RentRight.RentRight;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

import com.RentRight.RentRight.dto.ApartmentInputDTO;
import com.RentRight.RentRight.dto.ApartmentOutputDTO;
import com.RentRight.RentRight.entities.Apartment;
import com.RentRight.RentRight.repositories.ApartmentRepository;
import com.RentRight.RentRight.services.ApartmentService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)


public class ApartamentRegisterTest {
    
    @InjectMocks
    private ApartmentService service;

    @Mock
    private ApartmentRepository repository;

    @Test
    void registerApartmentComSucesso(){

        ApartmentInputDTO apartmentInput = new ApartmentInputDTO(1l, "Favela", 500.34, 1, 2, 30);

        Apartment apartment = new Apartment(apartmentInput);

        when(repository.existsById(anyLong())).thenReturn(true);
        when(repository.save(any())).thenReturn(apartment);

        ApartmentOutputDTO apartmentAtualizado = service.update((apartmentInput));

        assertEquals(apartmentInput.getId(), apartmentAtualizado.getId());
        assertEquals(apartmentInput.getAddress(), apartmentAtualizado.getAddress());
        assertEquals(apartmentInput.getRentalPrice(), apartmentAtualizado.getRentalPrice());
        assertEquals(apartmentInput.getBathroomNumber(), apartmentAtualizado.getBathroomNumber());
        assertEquals(apartmentInput.getBedroomsNumber(), apartmentAtualizado.getBedroomsNumber());
        assertEquals(apartmentInput.getSize(), apartmentAtualizado.getSize());

    }
}
