package clinic.usuario;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Desenvolvimento02
 */
@Repository
public interface AuthoritiesRepository extends CrudRepository<Authorities, Long> {
    
    List<Authorities> findByUsername(String username);
}
