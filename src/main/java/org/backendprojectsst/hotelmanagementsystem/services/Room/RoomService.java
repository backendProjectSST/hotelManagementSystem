package org.backendprojectsst.hotelmanagementsystem.services.Room;

import org.backendprojectsst.hotelmanagementsystem.models.Room;
import org.backendprojectsst.hotelmanagementsystem.models.RoomStatus;


import java.util.List;
public interface RoomService 
{
    List<Room> getAllRooms();
    Room getRoomByCustomerId(long id);
    RoomStatus getRoomStatus(long id);
    List<Room> getRoomsbyStatus(RoomStatus roomStatus);
    Room addRoom(Room room);
    Room updateRoomOccupancy(Room room, Long customerId);
    Room updateRoomPrice(Room room, double price);
    Room updateRoomType(Room room, String type);
    void deleteRoom(long id);
}