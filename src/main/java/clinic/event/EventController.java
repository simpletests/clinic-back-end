package clinic.event;

import clinic.user.User;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import clinic.user.UserRepository;

/**
 *
 * @author tomaslm
 */
@CrossOrigin
@RestController
@RequestMapping("{idUsuario}/consulta")
public class EventController {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    UserRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<Event>> getLista(@PathVariable("idUsuario") Long idUsuario,
            @RequestParam("month") int month, @RequestParam("year") int year) {
        User usuario = usuarioRepository.findOne(idUsuario);
        return new ResponseEntity(eventRepository
                .findByUsuarioAndInicioBetween(usuario, LocalDate.of(year, month, 0).atStartOfDay(),
                        LocalDate.of(year, month, 0).atStartOfDay()), HttpStatus.OK);

    }

    @PostMapping
    public void criaNovo(@PathVariable("idUsuario") Long idUsuario, @RequestBody Event event) {
        eventRepository.save(event);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable("id") Long id) {
        eventRepository.delete(id);
    }

}
