package clinic.patient;

import clinic.paciente.QPaciente;
import clinic.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Tomas
 */
public interface PatientRepository extends PagingAndSortingRepository<Patient, Long>, QueryDslPredicateExecutor<Patient> {

    Page<Patient> findByUsuario(User u, Pageable pageable);

    default Patient findByUsuarioAndId(User u, Long id) {
        return findOne(QPaciente.paciente.usuario.eq(u).and(QPaciente.paciente.id.eq(id)));
    }
}
