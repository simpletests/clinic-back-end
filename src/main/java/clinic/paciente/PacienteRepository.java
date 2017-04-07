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

    default Paciente findByUsuarioAndId(Usuario u, Long id) {
        return findOne(QPaciente.paciente.usuario.eq(u).and(QPaciente.paciente.id.eq(id)));
    }
}
