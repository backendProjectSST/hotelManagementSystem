package org.backendprojectsst.hotelmanagementsystem.models;

import jakarta.persistence.*;

import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String name;
    private String contact;
    private String email;
    private Boolean isCheckedIn = false;

    @OneToOne
    private Room room;

    @ManyToOne
    @JoinColumn
    BookingDetails bookingDetails;
}
