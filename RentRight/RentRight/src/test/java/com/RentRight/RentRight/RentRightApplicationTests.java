package com.RentRight.RentRight;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.RentRight.RentRight.dto.ContractInputDTO;
import com.RentRight.RentRight.dto.ContractOutputDTO;
import com.RentRight.RentRight.entities.Contract;
import com.RentRight.RentRight.repositories.ContractRepository;
import com.RentRight.RentRight.services.ContractService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class RentRightApplicationTests {

	@InjectMocks
	private ContractService service;

	@Mock
	private ContractRepository repository;

	@Test
	void contractAtualizadoComSucesso(){

		ContractInputDTO contractInput = new ContractInputDTO(1l, "2005-02-04T12:04:12.000-03:00", "2000-01-05T13:05:32.000-03:00");

		Contract contract = new Contract(contractInput);
		contract.setId(1l);

		when(repository.existsById(anyLong())).thenReturn(true);
		when(repository.save(any())).thenReturn(contract);

		ContractOutputDTO contractAtualizado = service.update(contractInput);

		assertEquals(contractInput.getId(), contractAtualizado.getId());
		assertEquals(contractInput.getStartDate(), contractAtualizado.getStartDate());
		assertEquals(contractInput.getEndDate(), contractAtualizado.getEndDate());

	}

	@Test 
	void ReservationRegister() {

	}

}
