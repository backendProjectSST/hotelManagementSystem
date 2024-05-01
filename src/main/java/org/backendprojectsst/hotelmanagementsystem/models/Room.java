package org.backendprojectsst.hotelmanagementsystem.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
    private Customer customer;
}
