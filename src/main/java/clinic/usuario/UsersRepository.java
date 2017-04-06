package clinic.usuario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wesley
 */
@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {
    
}
