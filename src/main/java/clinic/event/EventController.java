package clinic.event;

import clinic.user.User;
import clinic.user.UserRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author tomaslm
 */
@CrossOrigin
@RestController
@RequestMapping("{idUser}/event")
public class EventController {

    final DateTimeFormatter javascriptFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    @Autowired
    EventRepository eventRepository;

    @Autowired
    UserRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<Event>> getLista(@PathVariable("idUser") Long idUser,
            @RequestParam(value = "start", required = false) String start,
            @RequestParam(value = "end", required = false) String end) {
//        start = LocalDate.of(2016, 3, 1).atStartOfDay().toString();
//        end = LocalDate.of(2018, 5, 1).atStartOfDay().toString();
        User user = usuarioRepository.findOne(idUser);
        if (start != null && end != null) {
            List<Event> retorno = eventRepository
                    .findByPatientUserAndStartBetween(user, LocalDateTime.parse(start, javascriptFormatter),
                            LocalDateTime.parse(end, javascriptFormatter));
            return new ResponseEntity(retorno, HttpStatus.OK);
        } else {
            return new ResponseEntity(eventRepository
                    .findByPatientUserAndStartBetween(user, LocalDateTime.MIN, LocalDateTime.MAX), HttpStatus.OK);
        }

    }

    @PostMapping
    public void createNew(@PathVariable("idUser") Long idUser, @RequestBody Event event) {
        eventRepository.save(event);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable("id") Long id, UriComponentsBuilder uriBuilder) {
        eventRepository.delete(id);
    }

    @GetMapping("/{id}")
    public Event getEvent(@PathVariable("id") Long id) {
        return eventRepository.findOne(id);
    }

}
