package pl.piotrbartoszak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piotrbartoszak.model.Tenant;

import javax.transaction.Transactional;

@Transactional
public interface TenantRepository extends JpaRepository<Tenant, Long> {
}
