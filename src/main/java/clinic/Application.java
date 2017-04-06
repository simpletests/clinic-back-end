package clinic;

import java.security.Principal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@EnableResourceServer
//@EnableAuthorizationServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableWebSecurity
@RestController
public class Application {
    
    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
