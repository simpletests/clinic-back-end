package clinic.paciente;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author Tomas
 */
@RepositoryRestResource(collectionResourceRel = "pacientes", path = "pacientes")
public interface PacienteRepository extends CrudRepository<Paciente, Long> {

}
