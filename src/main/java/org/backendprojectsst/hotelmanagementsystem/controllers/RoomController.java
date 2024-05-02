package org.backendprojectsst.hotelmanagementsystem.controllers;

import org.backendprojectsst.hotelmanagementsystem.exceptions.InvalidRoomIDException;
import org.backendprojectsst.hotelmanagementsystem.exceptions.RoomAlreadyOccupiedException;
import org.backendprojectsst.hotelmanagementsystem.models.Room;
import org.backendprojectsst.hotelmanagementsystem.models.RoomStatus;
import org.backendprojectsst.hotelmanagementsystem.models.RoomType;
import org.backendprojectsst.hotelmanagementsystem.services.Room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController
{
    private final RoomService roomService;

    private RoomController(RoomService roomService)
    {
        this.roomService = roomService;
    }

    @GetMapping("")
    public List<Room> getAllRooms()
    {
        return roomService.getAllRooms();
    }

    @GetMapping("/status/")
    public List<Room> getRoomsByStatus(@RequestParam RoomStatus status)
    {
        return roomService.getRoomsbyStatus(status);
    }

    @GetMapping("/type/{type}")
    public List<Room> getRoomsByType(@PathVariable RoomType type)
    {
        return roomService.getRoomsbyType(type);
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable long id) throws InvalidRoomIDException
    {
        if(!roomService.isRoom(id)) throw new InvalidRoomIDException("Invalid Room ID");
        return roomService.getRoomByCustomerId(id);
    }

    @GetMapping("/status/{id}")
    public RoomStatus getRoomStatus(@PathVariable long id) throws InvalidRoomIDException
    {
        if(!roomService.isRoom(id)) throw new InvalidRoomIDException("Invalid Room ID");
        return roomService.getRoomStatus(id);
    }

    @PostMapping()
    public Room addRoom(@RequestBody Room room)
    {
        return roomService.addRoom(room);
    }

    @PutMapping("/{id}/occupy/{customerId}")
    public Room updateRoomOccupancy(@PathVariable long id, @PathVariable long customerId) throws InvalidRoomIDException, RoomAlreadyOccupiedException
    {
        if(!roomService.isRoom(id)) throw new InvalidRoomIDException("Invalid Room ID");
        if(roomService.getRoomByCustomerId(id).getCustomer() != null) throw new RoomAlreadyOccupiedException("Room is already occupied");
        return roomService.updateRoomOccupancy(roomService.getRoomByCustomerId(id), customerId);
    }

    @PutMapping("/{id}/vacate")
    public Room vacateRoom(@PathVariable long id) throws InvalidRoomIDException
    {
        if(!roomService.isRoom(id)) throw new InvalidRoomIDException("Invalid Room ID");
        return roomService.updateRoomOccupancy(roomService.getRoomByCustomerId(id), null);
    }

    @PutMapping("/{id}/price")
    public Room updateRoomPrice(@PathVariable long id, @RequestBody double price) throws InvalidRoomIDException
    {
        if(!roomService.isRoom(id)) throw new InvalidRoomIDException("Invalid Room ID");
        return roomService.updateRoomPrice(roomService.getRoomByCustomerId(id), price);
    }

    @PutMapping("/{id}/type")
    public Room updateRoomType(@PathVariable long id, @RequestBody String type) throws InvalidRoomIDException
    {
        if(!roomService.isRoom(id)) throw new InvalidRoomIDException("Invalid Room ID");
        return roomService.updateRoomType(roomService.getRoomByCustomerId(id), type);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable long id) throws InvalidRoomIDException
    {
        if(!roomService.isRoom(id)) throw new InvalidRoomIDException("Invalid Room ID");
        roomService.deleteRoom(id);
    }



}
