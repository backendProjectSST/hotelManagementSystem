package org.backendprojectsst.hotelmanagementsystem.services.Room;

import org.backendprojectsst.hotelmanagementsystem.models.Customer;
import org.backendprojectsst.hotelmanagementsystem.models.Room;
import org.backendprojectsst.hotelmanagementsystem.models.RoomStatus;
import org.backendprojectsst.hotelmanagementsystem.models.RoomType;
import org.backendprojectsst.hotelmanagementsystem.repositories.CustomerRepository;
import org.backendprojectsst.hotelmanagementsystem.repositories.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final CustomerRepository customerRepository;
    public RoomServiceImpl(RoomRepository roomRepository, CustomerRepository customerRepository) {
        this.roomRepository = roomRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room getRoomByCustomerId(long id) {
        return roomRepository.findById(id).orElse(null);
    }

    @Override
    public RoomStatus getRoomStatus(long id) {
        Room room = roomRepository.findById(id).orElse(null);
        if (room == null) return null;
        return room.getRoomStatus();
    }

    @Override
    public List<Room> getRoomsbyStatus(RoomStatus roomStatus) {
        return roomRepository.findAllByRoomStatus(roomStatus).orElse(null);
    }

    @Override
    public Room addRoom(Room room) {
        if (Objects.isNull(room)) return null;
        return roomRepository.save(room);
    }

    @Override
    public Room updateRoomOccupancy(Room room, Long customerId) {
        Room existingRoom = roomRepository.findById(room.getRoom_id()).orElse(null);
        if(existingRoom == null) return null;
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if(customer == null) return null;
        existingRoom.setCustomer(customer);
        roomRepository.save(existingRoom);
        return roomRepository.findById(room.getRoom_id()).orElse(null);
    }

    @Override
    public Room updateRoomType(Room room, String type) {
        Room existingRoom = roomRepository.findById(room.getRoom_id()).orElse(null);
        if (existingRoom == null) return null;
        existingRoom.setRoomType(RoomType.valueOf(type));
        roomRepository.save(existingRoom);
        return roomRepository.findById(room.getRoom_id()).orElse(null);
    }

    @Override
    public Room updateRoomPrice(Room room, double price) {
        Room existingRoom = roomRepository.findById(room.getRoom_id()).orElse(null);
        if (existingRoom == null) return null;
        existingRoom.setPrice(price);
        roomRepository.save(existingRoom);
        return roomRepository.findById(room.getRoom_id()).orElse(null);
    }

    @Override
    public void deleteRoom(long id) {
        roomRepository.deleteById(id);
    }
}
