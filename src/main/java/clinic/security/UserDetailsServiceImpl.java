package clinic.security;

import clinic.usuario.AuthoritiesRepository;
import clinic.usuario.UsersRepository;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author wesley
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private AuthoritiesRepository authoritiesRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usersRepository.findByUsername(username)
            .map(u -> new User(u.getUsername(), u.getPassword(),
            AuthorityUtils.commaSeparatedStringToAuthorityList(authoritiesRepository.findByUsername(username).stream().map(a -> a.getAuthority()).collect(Collectors.joining(",")))))
            .orElseThrow(() -> new UsernameNotFoundException("couldn't find the username " + username + "!"));
    }
    
}
