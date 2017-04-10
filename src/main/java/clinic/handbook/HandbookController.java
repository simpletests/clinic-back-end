package clinic.handbook;

import clinic.patient.Patient;
import clinic.patient.PatientRepository;
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
@RequestMapping("{idPatient}/prontuario")
public class HandbookController {

    @Autowired
    PatientRepository pacienteRepository;

    @Autowired
    HandbookRepository prontuarioRepository;

    @GetMapping
    public ResponseEntity<Page<Handbook>> getLista(@PathVariable("idPatient") long idPaciente,
            @RequestParam("page") int page, @RequestParam("size") int size) {
        Patient paciente = pacienteRepository.findOne((long) idPaciente);
        Page<Handbook> prontuarios = prontuarioRepository.findByPaciente(paciente,
                new PageRequest(page, size, Sort.Direction.ASC, "data"));
        if (prontuarios.getNumberOfElements() > 0) {
            return new ResponseEntity(prontuarios, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}
