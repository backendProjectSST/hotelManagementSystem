package org.backendprojectsst.hotelmanagementsystem.controllers;

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

    @Autowired
    private RoomController(RoomService roomService)
    {
        this.roomService = roomService;
    }

    @GetMapping("")
    public List<Room> getAllRooms()
    {
        return roomService.getAllRooms();
    }

    @GetMapping("/status/{status}")
    public List<Room> getRoomsByStatus(@PathVariable RoomStatus status)
    {
        return roomService.getRoomsbyStatus(status);
    }

    @GetMapping("/type/{type}")
    public List<Room> getRoomsByType(@PathVariable RoomType type)
    {
        return roomService.getRoomsbyType(type);
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable long id)
    {
        return roomService.getRoomByCustomerId(id);
    }

    @GetMapping("/status/{id}")
    public RoomStatus getRoomStatus(@PathVariable long id)
    {
        return roomService.getRoomStatus(id);
    }

    @PostMapping()
    public Room addRoom(@RequestBody Room room)
    {
        return roomService.addRoom(room);
    }

    @PutMapping("/{id}/occupy/{customerId}")
    public Room updateRoomOccupancy(@PathVariable long id, @PathVariable long customerId)
    {
        return roomService.updateRoomOccupancy(roomService.getRoomByCustomerId(id), customerId);
    }

    @PutMapping("/{id}/vacate")
    public Room vacateRoom(@PathVariable long id)
    {
        return roomService.updateRoomOccupancy(roomService.getRoomByCustomerId(id), null);
    }

    @PutMapping("/{id}/price")
    public Room updateRoomPrice(@PathVariable long id, @RequestBody double price)
    {
        return roomService.updateRoomPrice(roomService.getRoomByCustomerId(id), price);
    }

    @PutMapping("/{id}/type")
    public Room updateRoomType(@PathVariable long id, @RequestBody String type)
    {
        return roomService.updateRoomType(roomService.getRoomByCustomerId(id), type);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable long id)
    {
        roomService.deleteRoom(id);
    }



}
