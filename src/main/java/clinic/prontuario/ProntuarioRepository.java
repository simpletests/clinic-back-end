package clinic.prontuario;

import clinic.paciente.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author tomaslm
 */
public interface ProntuarioRepository extends PagingAndSortingRepository<Prontuario, Long> {

    public Page<Prontuario> findByPaciente(Paciente paciente, Pageable pageable);
}
