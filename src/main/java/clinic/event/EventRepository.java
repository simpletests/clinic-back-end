package clinic.event;

import clinic.user.User;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author tomaslm
 */
public interface EventRepository extends PagingAndSortingRepository<Event, Long>, QueryDslPredicateExecutor<Event> {

    public List<Event> findByPatientUserAndStartBetween(User user, LocalDateTime startDate, LocalDateTime endDate);

    public List<Event> findByPatientUser(User user);
}
