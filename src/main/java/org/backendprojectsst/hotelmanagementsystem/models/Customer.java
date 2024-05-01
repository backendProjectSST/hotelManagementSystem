package org.backendprojectsst.hotelmanagementsystem.models;

import jakarta.persistence.*;

import java.util.*;

import lombok.Data;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customer_id;

    private String name;
    private String contact;
    private String email;

    @ManyToOne
    private Room room;

    @ManyToOne
    BookingDetails bookingDetails;
}