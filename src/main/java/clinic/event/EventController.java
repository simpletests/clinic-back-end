package clinic.event;

import clinic.user.User;
import clinic.user.UserRepository;
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

/**
 *
 * @author tomaslm
 */
@CrossOrigin
@RestController
@RequestMapping("{idUser}/event")
public class EventController {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    UserRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<Event>> getLista(@PathVariable("idUser") Long idUser,
            @RequestParam("month") int month, @RequestParam("year") int year) {
        User user = usuarioRepository.findOne(idUser);
        return new ResponseEntity(eventRepository
                .findByPatientUserAndStartBetween(user, LocalDate.of(year, month, 1).atStartOfDay(),
                        LocalDate.of(year, month + 1, 1).atStartOfDay()), HttpStatus.OK);

    }

    @PostMapping
    public void createNew(@PathVariable("idUser") Long idUser, @RequestBody Event event) {
        eventRepository.save(event);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable("id") Long id) {
        eventRepository.delete(id);
    }

}
