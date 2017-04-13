package clinic.user;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Tomas
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
