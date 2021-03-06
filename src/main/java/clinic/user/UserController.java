package clinic.user;

import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Tomas
 */
@CrossOrigin
@RestController
@RequestMapping("/{idUser}/user")
@Secured("ROLE_ADMINISTRADOR")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<Page<User>> findAll(@RequestParam("page") int page, @RequestParam("size") int size, @RequestParam("search") String search) {
        Predicate predicate = QUser.user.name.likeIgnoreCase("%" + search + "%");
        return new ResponseEntity<>(userRepository.findAll(predicate, new QPageRequest(page, size)), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findOne(@PathVariable Long id) {
        return new ResponseEntity<>(userRepository.findOne(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        userRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/new")
    public ResponseEntity<User> getNew(@PathVariable("idUser") long idUser) {
        User usuario = userRepository.findOne(idUser);
        return new ResponseEntity(new User(), HttpStatus.OK);
    }
}
