package org.backendprojectsst.hotelmanagementsystem.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long room_id;
    private RoomStatus roomStatus;
    private RoomType roomType;
    private double price;

    @OneToOne
    private Customer customer;
}
