package clinic.security;

/**
 *
 * @author wesley
 */
public interface SecurityService {
    
    String findLoggedInUsername();
    void autologin(String username, String password);
}
