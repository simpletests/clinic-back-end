package clinic.paciente;

import clinic.usuario.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Tomas
 */
public interface PacienteRepository extends PagingAndSortingRepository<Paciente, Long>, QueryDslPredicateExecutor<Paciente> {

    Page<Paciente> findByUsuario(Usuario u, Pageable pageable);

    Paciente findByUsuarioAndId(Usuario u, Long id);
}
