package pl.piotrbartoszak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piotrbartoszak.model.Flat;

import javax.transaction.Transactional;

@Transactional
public interface FlatRepository extends JpaRepository<Flat, Long> {
}
