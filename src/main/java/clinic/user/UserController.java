package clinic.user;

import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Tomas
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping
    @Secured("ROLE_ADMINISTRADOR")
    public ResponseEntity<Page<User>> getLista(@RequestParam("page") int page, @RequestParam("size") int size, @RequestParam("search") String search) {
        Predicate predicate = QUser.user.username.likeIgnoreCase("%" + search + "%");
        return new ResponseEntity<>(userRepository.findAll(predicate, new QPageRequest(page, size)), HttpStatus.OK);
    }
}
