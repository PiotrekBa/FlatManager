package pl.piotrbartoszak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.piotrbartoszak.model.Room;
import pl.piotrbartoszak.model.Tenant;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface RoomRepository extends JpaRepository<Room, Long> {
}
