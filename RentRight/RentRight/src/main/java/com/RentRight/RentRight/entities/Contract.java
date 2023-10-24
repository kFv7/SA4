package com.RentRight.RentRight.entities;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.*;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Contract {
    @Id @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;
    private Date startDate;
    private Date endDate;

    @ManyToOne
    private User user;
    @ManyToOne
    private Apartment apartment;
}
