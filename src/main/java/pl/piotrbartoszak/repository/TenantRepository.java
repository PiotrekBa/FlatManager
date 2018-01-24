package pl.piotrbartoszak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.piotrbartoszak.model.Tenant;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface TenantRepository extends JpaRepository<Tenant, Long> {

    @Query("select t from Tenant t where t.room.id = ?1")
    List<Tenant> findAllTenantsByRoomId(long id);

}
