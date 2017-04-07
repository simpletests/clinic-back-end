package clinic.prontuario;

import clinic.paciente.Paciente;
import clinic.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tomaslm
 */
@CrossOrigin
@RestController
@RequestMapping("{idPaciente}/prontuario")
public class ProntuarioController {

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    ProntuarioRepository prontuarioRepository;

    @GetMapping
    public ResponseEntity<Page<Prontuario>> getLista(@PathVariable("idPaciente") long idPaciente,
            @RequestParam("page") int page, @RequestParam("size") int size) {
        Paciente paciente = pacienteRepository.findOne((long) idPaciente);
        Page<Prontuario> prontuarios = prontuarioRepository.findByPaciente(paciente,
                new PageRequest(page, size, Sort.Direction.ASC, "data"));
        if (prontuarios.getNumberOfElements() > 0) {
            return new ResponseEntity(prontuarios, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}
