package ro.fortech.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.fortech.project.entities.ERoomType;
import ro.fortech.project.entities.Room;

import java.util.List;


@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findAllByRoomType(ERoomType roomType);
}
