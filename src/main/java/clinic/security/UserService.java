package clinic.security;

import clinic.usuario.User;

/**
 *
 * @author wesley
 */
public interface UserService {

    void save(User user);
    User findByUsername(String username);
}
