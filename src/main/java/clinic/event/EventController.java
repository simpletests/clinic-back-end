package clinic.event;

import clinic.user.User;
import clinic.user.UserRepository;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

    @Autowired
    EventRepository eventRepository;

    @Autowired
    UserRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<Event>> getLista(@PathVariable("idUser") Long idUser,
            @RequestParam(value = "start", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam(value = "end", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
//        start = LocalDate.of(2016, 3, 1).atStartOfDay().toString();
//        end = LocalDate.of(2018, 5, 1).atStartOfDay().toString();
        User user = usuarioRepository.findOne(idUser);
        start = null;
        end = null;
        if (start != null && end != null) {
            List<Event> retorno = eventRepository
                    .findByPatientUserAndStartBetween(user, start, end);
            return new ResponseEntity(retorno, HttpStatus.OK);
        } else {
            return new ResponseEntity(eventRepository
                    .findByPatientUserAndStartBetween(user, LocalDateTime.of(0, Month.JANUARY, 1, 0, 0), LocalDateTime.MAX), HttpStatus.OK);
        }

    }

    @PostMapping
    public void saveOrUpdate(@PathVariable("idUser") Long idUser, @RequestBody Event event) {
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

    @GetMapping("/new")
    public Event getNew() {
        return new Event();
    }

}
