package clinic.paciente;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tomas
 */
@Repository//RestResource(collectionResourceRel = "pacientes", path = "pacientes")
public interface PacienteRepository extends CrudRepository<Paciente, Long> {

}
