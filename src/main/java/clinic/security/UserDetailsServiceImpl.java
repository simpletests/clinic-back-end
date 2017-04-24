package clinic.security;

import clinic.usuario.AuthoritiesRepository;
import clinic.usuario.UsersRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
        List<GrantedAuthority> authorities = authoritiesRepository.findByUsername(username).stream()
            .map(a -> new SimpleGrantedAuthority("ROLE_" + a.getAuthority())).collect(Collectors.toList());
        return usersRepository.findByUsername(username)
            .map(u -> new User(u.getUsername(), u.getPassword(), authorities))
            .orElseThrow(() -> new UsernameNotFoundException("Couldn't find the username " + username + "!"));
    }
}
