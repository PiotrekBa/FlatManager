package pl.piotrbartoszak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piotrbartoszak.model.Owner;

import javax.transaction.Transactional;

@Transactional
public interface OwnerRepository extends JpaRepository<Owner, Long> {

}
