package pl.piotrbartoszak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piotrbartoszak.model.Room;

import javax.transaction.Transactional;

@Transactional
public interface RoomRepository extends JpaRepository<Room, Long> {
}
