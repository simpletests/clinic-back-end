package clinic.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wesley
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    
}
