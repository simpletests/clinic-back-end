package clinic.application;

import clinic.common.Endereco;
import clinic.common.Sexo;
import clinic.paciente.Paciente;
import clinic.paciente.PacienteRepository;
import clinic.prontuario.Prontuario;
import clinic.prontuario.ProntuarioRepository;
import clinic.usuario.Usuario;
import clinic.usuario.UsuarioRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 *
 * @author Tomas
 */
@Component
public class ApplicationLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ProntuarioRepository prontuarioRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        Usuario medico1 = new Usuario("Dr. Carlos da Silva Santos", "123");
        Usuario medico2 = new Usuario("Dra. Silvia Maria da Silva", "123");
        usuarioRepository.save(medico1);

        usuarioRepository.save(medico2);

        Paciente tomas = new Paciente(medico1, "Tomas", "tomaslm@hotmail.com",
                new Endereco("Rua São José", 100, "casa", "São Paulo", "Ribeirão Preto", "Brasil"),
                22, Sexo.MASCULINO, "3202-3063", "99222-1131");
        Paciente sabrina = new Paciente(medico1, "Sabrina", "tomaslm@hotmail.com",
                new Endereco("Rua São José", 100, "casa", "São Paulo", "Ribeirão Preto", "Brasil"),
                22, Sexo.FEMININO, "3202-3063", "99332-1131");
        Paciente wesley = new Paciente(medico2, "Wesley", "wesley@hotmail.com",
                new Endereco("Rua do Sertão", 250, "apto 3", "São Paulo", "Sertãozinho", "Brasil"),
                25, Sexo.MASCULINO, "3111-3543", "98742-6985");
        pacienteRepository.save(tomas);
        pacienteRepository.save(sabrina);
        pacienteRepository.save(wesley);
        prontuarioRepository.save(new Prontuario(tomas, LocalDateTime.now().minusDays(60), "Fadiga muscular"));
        prontuarioRepository.save(new Prontuario(tomas, LocalDateTime.now().minusDays(30), "Sintomas aparentes de gripe"));
        prontuarioRepository.save(new Prontuario(sabrina, LocalDateTime.now().minusDays(30), "Febre de 38 graus"));
    }
}
