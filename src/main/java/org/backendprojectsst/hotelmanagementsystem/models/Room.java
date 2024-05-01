package org.backendprojectsst.hotelmanagementsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long room_id;
    private Room_status roomStatus;
    private Room_type roomType;
    private double price;

    @ManyToOne
    private Customer customer;
}
