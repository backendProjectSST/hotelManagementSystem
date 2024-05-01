package org.backendprojectsst.hotelmanagementsystem.models;

import jakarta.persistence.*;

import java.util.*;

import lombok.Data;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String name;
    private String contact;
    private String email;

    @OneToOne
    private Room room;


    @ManyToOne
    @JoinColumn
    BookingDetails bookingDetails;
}
