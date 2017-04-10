package clinic.patient;

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

    Page<Patient> findByUser(User u, Pageable pageable);

    Patient findByUserAndId(User u, Long id);
}
