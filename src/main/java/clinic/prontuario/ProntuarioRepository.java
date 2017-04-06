package clinic.prontuario;

import clinic.paciente.Paciente;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author tomaslm
 */
public interface ProntuarioRepository extends CrudRepository<Prontuario, Long> {

    public List<Prontuario> findByPacienteOrderByData(Paciente paciente);
}
