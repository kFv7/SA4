package com.RentRight.RentRight;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.RentRight.RentRight.entities.User;
import com.RentRight.RentRight.repositories.UserRepository;
import com.RentRight.RentRight.services.UserService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserRegisterTest {

    @InjectMocks
    private UserService service;

    @Mock
    private UserRepository repository;

    @Test
    void RegisterUserComSucesso() {
        
        User userInput = new User(1l, "geraldo", "geraldo@gmail.com", "00000000", "Credp123");

        User user = new User(userInput);

        when(repository.existsById(anyLong())).thenReturn(true);
        when(repository.save(any())).thenReturn(user);

        User userAtualizado = service.update((userInput));

        assertEquals(userInput.getId(), userAtualizado.getId());
        assertEquals(userInput.getName(), userAtualizado.getName());
        assertEquals(userInput.getEmail(), userAtualizado.getEmail());
        assertEquals(userInput.getCPF(), userAtualizado.getCPF());
        assertEquals(userInput.getPassword(), userAtualizado.getPassword());
    }
}
