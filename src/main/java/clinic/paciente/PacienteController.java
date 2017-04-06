package clinic.paciente;

import clinic.usuario.Usuario;
import clinic.usuario.UsuarioRepository;
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

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Iterable<Paciente>> getLista(@PathVariable("idUsuario") long idUsuario) {
        Usuario u = usuarioRepository.findOne(idUsuario);
        Iterable<Paciente> pacientes = pacienteRepository.findByUsuario(u);
        if (pacientes.iterator().hasNext()) {
            return new ResponseEntity(pacientes, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{idUsuario}/{id}")
    public ResponseEntity<Paciente> findById(@PathVariable("idUsuario") long idUsuario, @PathVariable("id") long id) {
        Usuario usuario = usuarioRepository.findOne(idUsuario);
        Paciente paciente = pacienteRepository.findByUsuarioAndId(usuario, id);
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

    @DeleteMapping("/{id}")
    public void deletePaciente(@PathVariable("id") long id) {
        pacienteRepository.delete(id);
    }
}
