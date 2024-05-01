package org.backendprojectsst.hotelmanagementsystem.models;

import jakarta.annotation.Nullable;
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

    @ManyToOne
    @Nullable
    private Customer customer;
}
