package ro.fortech.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.fortech.project.entities.ERoomType;
import ro.fortech.project.entities.Room;
import ro.fortech.project.repository.RoomRepository;

import java.util.List;


@Service
public class RoomReservationService {

    @Autowired
    private RoomRepository roomRepository;

    public RoomReservationService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room updateRoom(Room room) {
        return roomRepository.save(room);

    }

    public void deleteRoom(Long roomNumber) {
        roomRepository.deleteById(roomNumber);
    }

    public List<Room> findAllRooms() {
        return roomRepository.findAll();
    }


    public Room getRoomByNumber(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error: Room is not found."));
    }

    public ERoomType getTypeOfRoom(String roomType) {
        return switch (roomType) {
            case "single" -> ERoomType.SINGLE;
            case "double" -> ERoomType.DOUBLE;
            case "triple" -> ERoomType.TRIPLE;
            case "family" -> ERoomType.FAMILY;
            default -> throw new IllegalStateException("Unexpected value: " + roomType);
        };
    }
}
