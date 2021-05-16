package p.doctor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import p.doctor.entity.Room;

public interface RoomDao extends JpaRepository<Room,Integer>, JpaSpecificationExecutor<Room> {
    Room findFirstById(Integer id);
}
