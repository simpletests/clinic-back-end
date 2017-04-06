package clinic.prontuario;

import clinic.paciente.Paciente;
import clinic.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tomaslm
 */
@CrossOrigin
@RestController
@RequestMapping(name = "/prontuario")
public class ProntuarioController {

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    ProntuarioRepository prontuarioRepository;

    @GetMapping("/{idPaciente}")
    public ResponseEntity<Iterable<Prontuario>> getLista(@PathVariable long idPaciente) {
        Paciente paciente = pacienteRepository.findOne(idPaciente);
        Iterable<Prontuario> prontuarios = prontuarioRepository.findByPaciente(paciente);
        if (prontuarios.iterator().hasNext()) {
            return new ResponseEntity(prontuarios, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}
