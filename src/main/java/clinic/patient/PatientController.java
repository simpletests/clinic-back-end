package clinic.patient;

import clinic.paciente.QPaciente;
import clinic.user.User;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.querydsl.QPageRequest;
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
import clinic.user.UserRepository;

/**
 *
 * @author tomaslm
 */
@CrossOrigin
@RestController
@RequestMapping("/{idUsuario}/paciente")
public class PatientController {

    @Autowired
    PatientRepository pacienteRepository;

    @Autowired
    UserRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<Page<Patient>> getLista(@PathVariable("idUsuario") long idUsuario,
            @RequestParam("page") int page, @RequestParam("size") int size,
            @RequestParam("search") String search) {
        User u = usuarioRepository.findOne(idUsuario);
        Predicate predicate = QPaciente.paciente.nome.likeIgnoreCase("%" + search + "%")
                .and(QPaciente.paciente.usuario.eq(u));
        return new ResponseEntity(pacienteRepository.findAll(predicate, new QPageRequest(page, size)), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> findById(@PathVariable("idUsuario") long idUsuario, @PathVariable("id") long id) {
        User usuario = usuarioRepository.findOne(idUsuario);
//        Paciente paciente = pacienteRepository.findOne(QPaciente.paciente.usuario.eq(usuario).and(QPaciente.paciente.id.eq(id)));
        Patient paciente = pacienteRepository.findByUsuarioAndId(usuario, id);
        if (paciente != null) {
            return new ResponseEntity(paciente, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public void createPaciente(@RequestBody Patient paciente, UriComponentsBuilder uriBuilder) {
        paciente = pacienteRepository.save(paciente);
        if (paciente != null) {
        } else {
        }
    }

    @DeleteMapping("/{id}")
    public void deletePaciente(@PathVariable("id") long id) {
        pacienteRepository.delete(id);
    }
}
