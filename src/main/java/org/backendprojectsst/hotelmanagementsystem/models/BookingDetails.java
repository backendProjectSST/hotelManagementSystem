package org.backendprojectsst.hotelmanagementsystem.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
public class BookingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookingId;
    @ManyToOne
    @JoinColumn
    private Customer customer;
    @ManyToOne
    @JoinColumn
    private Room room;
    private BookingStatus bookingStatus;
    private LocalTime bookingTime;
    private LocalTime checkInTime;
    private LocalTime checkOutTime;
    private PaymentStatus paymentStatus;
    private PaymentMethod paymentMethod;
    private LocalDate paymentDate;
}
