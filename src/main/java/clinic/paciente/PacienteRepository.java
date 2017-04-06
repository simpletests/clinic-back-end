package clinic.paciente;

import clinic.usuario.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Tomas
 */
public interface PacienteRepository extends CrudRepository<Paciente, Long> {

    Iterable<Paciente> findByUsuario(Usuario u);

    Paciente findByUsuarioAndId(Usuario u, Long id);
}
