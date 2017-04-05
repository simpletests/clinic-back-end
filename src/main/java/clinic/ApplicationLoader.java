package clinic.application;

import clinic.common.Endereco;
import clinic.common.Sexo;
import clinic.paciente.Paciente;
import clinic.paciente.PacienteRepository;
import clinic.usuario.Role;
import clinic.usuario.RoleRepository;
import clinic.usuario.User;
import clinic.usuario.UserRepository;
import java.util.Arrays;
import java.util.HashSet;
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
    private PacienteRepository pacienteRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        Role roleAdmin = roleRepository.save(new Role("ADMIN", null));
        Role roleUser = roleRepository.save(new Role("USER", null));
        
        User user1 = new User("wesley", "123", new HashSet<>(Arrays.asList(roleAdmin)));
        User user2 = new User("tomas", "123", new HashSet<>(Arrays.asList(roleUser)));
        userRepository.save(user1);
        userRepository.save(user2);
        
        pacienteRepository.save(
                new Paciente("Tomas", "tomaslm@hotmail.com",
                        new Endereco("Rua São José", 100, "casa", "São Paulo", "Ribeirão Preto", "Brasil"),
                        22, Sexo.MASCULINO, "3202-3063", "99222-1131"));
        pacienteRepository.save(
                new Paciente("Sabrina", "tomaslm@hotmail.com",
                        new Endereco("Rua São José", 100, "casa", "São Paulo", "Ribeirão Preto", "Brasil"),
                        22, Sexo.FEMININO, "3202-3063", "99332-1131"));
        pacienteRepository.save(
                new Paciente("Wesley", "wesley@hotmail.com",
                        new Endereco("Rua do Sertão", 250, "apto 3", "São Paulo", "Sertãozinho", "Brasil"),
                        25, Sexo.MASCULINO, "3111-3543", "98742-6985"));
    }
}
