package clinic.prontuario;

import clinic.paciente.Paciente;
import clinic.paciente.PacienteRepository;
import java.util.List;
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
@RequestMapping("/prontuario")
public class ProntuarioController {

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    ProntuarioRepository prontuarioRepository;

    @GetMapping("/{idPaciente}/{offset}")
    public ResponseEntity<Iterable<Prontuario>> getLista(@PathVariable("idPaciente") long idPaciente,
            @PathVariable("offset") long offset) {
        Paciente paciente = pacienteRepository.findOne(idPaciente);
        List<Prontuario> prontuarios = prontuarioRepository.findByPacienteOrderByData(paciente);
        if (!prontuarios.isEmpty()) {
            return new ResponseEntity(prontuarios.get(0), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}
