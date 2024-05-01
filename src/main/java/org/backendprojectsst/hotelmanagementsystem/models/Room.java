package org.backendprojectsst.hotelmanagementsystem.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
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
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
