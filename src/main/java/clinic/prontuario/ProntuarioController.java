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

    @GetMapping("/{idPaciente}/{page}/{size}")
    public ResponseEntity<Page<Prontuario>> getLista(@PathVariable("idPaciente") long idPaciente,
            @PathVariable("page") int page, @PathVariable("size") int size) {
        Paciente paciente = pacienteRepository.findOne(idPaciente);
        Page<Prontuario> prontuarios = prontuarioRepository.findByPaciente(paciente,
                new PageRequest(page, size, Sort.DEFAULT_DIRECTION, "data"));
        if (prontuarios.getNumberOfElements() > 0) {
            return new ResponseEntity(prontuarios, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}
