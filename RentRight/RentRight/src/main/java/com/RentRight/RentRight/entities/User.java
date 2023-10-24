package com.RentRight.RentRight.entities;

import jakarta.persistence.*;
import lombok.*;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class User {
    @Id @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String CPF;
    private String password;
    
}
