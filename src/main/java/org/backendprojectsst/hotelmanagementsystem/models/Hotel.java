package org.backendprojectsst.hotelmanagementsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Hotel
{
    @Id
    private Long hotelId;

    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;
}
