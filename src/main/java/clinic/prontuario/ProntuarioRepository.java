package clinic.prontuario;

import clinic.paciente.Paciente;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author tomaslm
 */
public interface ProntuarioRepository extends CrudRepository<Prontuario, Long> {

    public Iterable<Prontuario> findByPaciente(Paciente paciente);
}
