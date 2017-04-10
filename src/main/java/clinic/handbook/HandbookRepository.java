package clinic.handbook;

import clinic.patient.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author tomaslm
 */
public interface HandbookRepository extends PagingAndSortingRepository<Handbook, Long>, QueryDslPredicateExecutor<Handbook> {

    public Page<Handbook> findByPatient(Patient paciente, Pageable pageable);
}
