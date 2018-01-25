package pl.piotrbartoszak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.piotrbartoszak.model.Finance;
import pl.piotrbartoszak.model.Flat;

import java.util.List;

public interface FinanceRepository extends JpaRepository<Finance, Long> {

    @Query("select f from Finance f where f.flat.id = ?1")
    List<Finance> findByFlat(long id);
}
