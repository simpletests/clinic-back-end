package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author tomaslm
 */
@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteRepository pacienteRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Paciente>> getLista() {
        Iterable<Paciente> pacientes = pacienteRepository.findAll();
        if (pacientes.iterator().hasNext()) {
            return new ResponseEntity(pacientes, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Paciente> findById(@PathVariable("id") long id) {
        Paciente paciente = pacienteRepository.findOne(id);
        if (paciente != null) {
            return new ResponseEntity(paciente, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void createPaciente(@RequestBody Paciente paciente, UriComponentsBuilder uriBuilder) {
        paciente = pacienteRepository.save(paciente);
        if (paciente != null) {
        } else {
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deletePaciente(@PathVariable("id") long id) {
        pacienteRepository.delete(id);
        return ResponseEntity.ok(id);
    }
}
