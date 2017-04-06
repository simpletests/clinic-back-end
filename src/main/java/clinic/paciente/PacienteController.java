package clinic.paciente;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author tomaslm
 */
@CrossOrigin
@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteRepository pacienteRepository;

    @GetMapping
    public ResponseEntity<Iterable<Paciente>> getLista() {
        Iterable<Paciente> pacientes = pacienteRepository.findAll();
        if (pacientes.iterator().hasNext()) {
            return new ResponseEntity(pacientes, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Paciente> findById(@PathVariable("id") long id) {
        Paciente paciente = pacienteRepository.findOne(id);
        if (paciente != null) {
            return new ResponseEntity(paciente, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public void createPaciente(@RequestBody Paciente paciente, UriComponentsBuilder uriBuilder) {
        paciente = pacienteRepository.save(paciente);
        if (paciente != null) {
        } else {
        }
    }

    @DeleteMapping(value = "/{id}")
    public void deletePaciente(@PathVariable("id") long id) {
        pacienteRepository.delete(id);
    }
}
