package clinic.application;

import clinic.common.Address;
import clinic.common.Gender;
import clinic.patient.Patient;
import clinic.handbook.Handbook;
import clinic.user.User;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import clinic.patient.PatientRepository;
import clinic.user.UserRepository;
import clinic.handbook.HandbookRepository;

/**
 *
 * @author Tomas
 */
@Component
public class ApplicationLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository usuarioRepository;

    @Autowired
    private PatientRepository pacienteRepository;

    @Autowired
    private HandbookRepository prontuarioRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        User medico1 = new User("Dr. Carlos da Silva Santos", "123");
        User medico2 = new User("Dra. Silvia Maria da Silva", "123");
        usuarioRepository.save(medico1);

        usuarioRepository.save(medico2);

        Patient tomas = new Patient(medico1, "Tomas", "tomaslm@hotmail.com",
                new Address("Rua São José", 100, "casa", "São Paulo", "Ribeirão Preto", "Brasil"),
                22, Gender.MASCULINO, "3202-3063", "99222-1131");
        Patient sabrina = new Patient(medico1, "Sabrina", "tomaslm@hotmail.com",
                new Address("Rua São José", 100, "casa", "São Paulo", "Ribeirão Preto", "Brasil"),
                22, Gender.FEMININO, "3202-3063", "99332-1131");
        Patient wesley = new Patient(medico2, "Wesley", "wesley@hotmail.com",
                new Address("Rua do Sertão", 250, "apto 3", "São Paulo", "Sertãozinho", "Brasil"),
                25, Gender.MASCULINO, "3111-3543", "98742-6985");
        pacienteRepository.save(tomas);
        pacienteRepository.save(sabrina);
        pacienteRepository.save(wesley);
        prontuarioRepository.save(new Handbook(tomas, LocalDateTime.now().minusDays(60), "Fadiga muscular"));
        prontuarioRepository.save(new Handbook(tomas, LocalDateTime.now().minusDays(30), "Sintomas aparentes de gripe"));
        prontuarioRepository.save(new Handbook(sabrina, LocalDateTime.now().minusDays(30), "Febre de 38 graus"));

        List<Patient> pacientes = new ArrayList();
        List<String> listaNomes = Arrays.asList("Tomas", "Wesley", "Arthur");
        for (int i = 0; i < 100; i++) {
            pacientes.add(new Patient(medico1, listaNomes.get(new Random().nextInt(listaNomes.size())) + " Clone " + i,
                    "tomaslm@hotmail.com",
                    new Address("Rua São José", 100, "casa", "São Paulo", "Ribeirão Preto", "Brasil"),
                    22, Gender.MASCULINO,
                    "3202-3063", "99222-1131"));
        }
        pacienteRepository.save(pacientes);
    }
}
