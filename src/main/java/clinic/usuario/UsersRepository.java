package clinic.usuario;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wesley
 */
@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {
    
    Optional<Users> findByUsername(String username);
}
