package clinic.patient;

import clinic.user.User;
import clinic.user.UserRepository;
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
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author tomaslm
 */
@CrossOrigin
@RestController
@RequestMapping("/{idUser}/patient")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping
    @Secured("ROLE_MEDICO")
    public ResponseEntity<Page<Patient>> getLista(@PathVariable("idUser") long idUser,
            @RequestParam("page") int page, @RequestParam("size") int size,
            @RequestParam("search") String search) {
        User u = userRepository.findOne(idUser);
        Predicate predicate = QPatient.patient.name.likeIgnoreCase("%" + search + "%")
                .and(QPatient.patient.user.eq(u));
        return new ResponseEntity(patientRepository.findAll(predicate, new QPageRequest(page, size)), HttpStatus.OK);
    }

    @GetMapping("/{id}")
//    @Secured("ROLE_SECRETARIA")
    public ResponseEntity<Patient> findById(@PathVariable("idUser") long idUser, @PathVariable("id") long id) {
        User usuario = userRepository.findOne(idUser);
//        Paciente paciente = pacienteRepository.findOne(QPaciente.paciente.usuario.eq(usuario).and(QPaciente.paciente.id.eq(id)));
        Patient patient = patientRepository.findByUserAndId(usuario, id);
        if (patient != null) {
            return new ResponseEntity(patient, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public void createPaciente(@RequestBody Patient paciente, UriComponentsBuilder uriBuilder) {
        paciente = patientRepository.save(paciente);
        if (paciente != null) {
        } else {
        }
    }

    @DeleteMapping("/{id}")
    public void deletePaciente(@PathVariable("id") long id) {
        patientRepository.delete(id);
    }
}
