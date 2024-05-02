package org.backendprojectsst.hotelmanagementsystem.services.Room;

import org.backendprojectsst.hotelmanagementsystem.models.*;
import org.backendprojectsst.hotelmanagementsystem.repositories.BookingDetailsRepository;
import org.backendprojectsst.hotelmanagementsystem.repositories.CustomerRepository;
import org.backendprojectsst.hotelmanagementsystem.repositories.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final CustomerRepository customerRepository;
    private final BookingDetailsRepository bookingDetailsRepository;
    public RoomServiceImpl(RoomRepository roomRepository, CustomerRepository customerRepository, BookingDetailsRepository bookingDetailsRepository) {
        this.roomRepository = roomRepository;
        this.customerRepository = customerRepository;
        this.bookingDetailsRepository = bookingDetailsRepository;
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
    public List<Room> getRoomsbyType(RoomType type)
    {
        return roomRepository.findAllByRoomType(type).orElse(null);
    }

    @Override
    public Room addRoom(Room room)
    {
        if (Objects.isNull(room)) return null;
        Customer customer = room.getCustomer();
        if(customer != null) customerRepository.save(customer);
        roomRepository.save(room);
        return room;
    }

    @Override
    public Room updateRoomOccupancy(Room room, Long customerId) {
        Room existingRoom = roomRepository.findById(room.getRoomId()).orElse(null);
        if(existingRoom == null) return null;
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if(customer == null) return null;
        existingRoom.setCustomer(customer);
        roomRepository.save(existingRoom);
        return roomRepository.findById(room.getRoomId()).orElse(null);
    }

    @Override
    public Room updateRoomType(Room room, String type) {
        Room existingRoom = roomRepository.findById(room.getRoomId()).orElse(null);
        if (existingRoom == null) return null;
        existingRoom.setRoomType(RoomType.valueOf(type));
        roomRepository.save(existingRoom);
        return roomRepository.findById(room.getRoomId()).orElse(null);
    }

    @Override
    public Room updateRoomPrice(Room room, double price) {
        Room existingRoom = roomRepository.findById(room.getRoomId()).orElse(null);
        if (existingRoom == null) return null;
        existingRoom.setPrice(price);
        roomRepository.save(existingRoom);
        return roomRepository.findById(room.getRoomId()).orElse(null);
    }

    @Override
    public void deleteRoom(long id) {
        roomRepository.deleteById(id);
    }

    public boolean isRoom(long id) {
        return roomRepository.existsById(id);
    }

}
