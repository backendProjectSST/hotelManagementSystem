package org.backendprojectsst.hotelmanagementsystem.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
public class BookingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookingId;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Room room;
    private LocalTime bookingTime;
    private LocalDate checkInTime;
    private LocalDate checkOutTime;
    private PaymentStatus paymentStatus;

}
