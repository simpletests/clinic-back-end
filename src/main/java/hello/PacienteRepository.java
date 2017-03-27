package hello;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author Tomas
 */
@RepositoryRestResource(collectionResourceRel = "pacientes", path = "pacientes")
public interface PacienteRepository extends PagingAndSortingRepository<Paciente, Long> {

}
