package org.backendprojectsst.hotelmanagementsystem.controllers;

import org.backendprojectsst.hotelmanagementsystem.models.Room;
import org.backendprojectsst.hotelmanagementsystem.services.Room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/status")
    public List<Room> getRoomsByStatus()
    {
        return null;
        // return roomService.getRoomsbyStatus();
    }
}
