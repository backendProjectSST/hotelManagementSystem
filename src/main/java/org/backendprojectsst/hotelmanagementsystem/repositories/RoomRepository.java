package org.backendprojectsst.hotelmanagementsystem.repositories;

import org.backendprojectsst.hotelmanagementsystem.models.Room;
import org.backendprojectsst.hotelmanagementsystem.models.RoomStatus;
import org.backendprojectsst.hotelmanagementsystem.models.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long>
{
    Optional<List<Room>> findAllByRoomStatus(RoomStatus roomStatus);
    Optional<List<Room>> findAllByRoomType(RoomType roomType);
}
