package org.backendprojectsst.hotelmanagementsystem.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;
    private RoomStatus roomStatus;
    private RoomType roomType;
    private double price;
    @Nullable
    @OneToOne
    private Customer customer;
}
