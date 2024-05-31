package org.backendprojectsst.hotelmanagementsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class BookingDetails {
    @Id()
    private long bookingId;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Room room;
    private Date bookingDate;
    private Date checkInTime;
    private Date checkOutTime;
    private PaymentStatus paymentStatus;

}
