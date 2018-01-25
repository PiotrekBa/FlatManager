package pl.piotrbartoszak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.piotrbartoszak.model.Flat;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface FlatRepository extends JpaRepository<Flat, Long> {

    @Query("select f from Flat f where f.owner.id = ?1")
    List<Flat> findByOwnerId(long id);

    @Query("select f from Flat f where f.owner.id = ?1 and f.enable = true")
    List<Flat>findEnableByOwnerId(long id);

}
