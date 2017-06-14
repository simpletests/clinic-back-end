package clinic;

import clinic.common.Gender;
import clinic.common.address.Address;
import clinic.event.Event;
import clinic.event.EventRepository;
import clinic.handbook.Handbook;
import clinic.handbook.HandbookRepository;
import clinic.patient.Patient;
import clinic.patient.PatientRepository;
import clinic.user.Role;
import clinic.user.User;
import clinic.user.UserRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
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
    private UserRepository userRepository;

    @Autowired
    private PatientRepository pacienteRepository;

    @Autowired
    private HandbookRepository prontuarioRepository;

    @Autowired
    private EventRepository eventRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        userRepository.save(new User("Wesley", "wesley", "123", true, Role.ADMINISTRADOR));
        userRepository.save(new User("Tomas", "tomas", "123", true, Role.ADMINISTRADOR));
        userRepository.save(new User("Arthur", "arthur", "123", true, Role.SECRETARIA));

        User medico1 = new User("Dr. Carlos", "carlos", "123", true, Role.MEDICO);
        User medico2 = new User("Dra. Silvia", "silvia", "123", true, Role.MEDICO);
        userRepository.save(medico1);

        userRepository.save(medico2);

        Patient tomas = new Patient(medico1, "Tomas", "tomaslm@hotmail.com",
                new Address("Rua São José", 100, "casa", null),
                LocalDate.of(1994, Month.JULY, 06), Gender.MALE, "3202-3063", "99222-1131");
        Patient sabrina = new Patient(medico1, "Sabrina", "tomaslm@hotmail.com",
                new Address("Rua São José", 100, "casa", null),
                LocalDate.of(1994, Month.JUNE, 16), Gender.FEMALE, "3202-3063", "99332-1131");
        Patient wesley = new Patient(medico2, "Wesley", "wesley@hotmail.com",
                new Address("Rua do Sertão", 250, "apto 3", null),
                LocalDate.of(1990, Month.MARCH, 20), Gender.MALE, "3111-3543", "98742-6985");
        pacienteRepository.save(tomas);
        pacienteRepository.save(sabrina);
        pacienteRepository.save(wesley);

        List<Patient> pacientes = new ArrayList();
        List<String> listaNomes = Arrays.asList("Tomas", "Wesley", "Arthur");
        for (int i = 0; i < 100; i++) {
            pacientes.add(new Patient(medico1, listaNomes.get(new Random().nextInt(listaNomes.size())) + " Clone " + i,
                    "tomaslm@hotmail.com",
                    new Address("Rua São José", 100, "casa", null),
                    LocalDate.of(1950, Month.MARCH, 25), Gender.MALE,
                    "3202-3063", "99222-1131"));
        }
        pacienteRepository.save(pacientes);

        eventRepository.save(new Event(LocalDateTime.of(LocalDate.now(), LocalTime.of(14, 0)),
                LocalDateTime.of(LocalDate.now(), LocalTime.of(14, 50)), sabrina, new Handbook(sabrina, LocalDateTime.now().minusDays(30), "", "", "", "", "", "", "Febre de 38 graus")));
        eventRepository.save(new Event(LocalDateTime.of(LocalDate.now(), LocalTime.of(15, 0)),
                LocalDateTime.of(LocalDate.now(), LocalTime.of(15, 50)), sabrina, new Handbook(sabrina, LocalDateTime.now().minusDays(60), "", "", "", "", "", "", "Fadiga muscular")));
        eventRepository.save(new Event(LocalDateTime.of(LocalDate.now(), LocalTime.of(16, 0)),
                LocalDateTime.of(LocalDate.now(), LocalTime.of(16, 50)), sabrina, new Handbook()));
        eventRepository.save(new Event(LocalDateTime.of(LocalDate.now().plusDays(3), LocalTime.of(14, 0)),
                LocalDateTime.of(LocalDate.now().plusDays(3), LocalTime.of(14, 50)), sabrina, new Handbook(sabrina, LocalDateTime.now().minusDays(30), "", "", "", "", "", "", "Sintomas aparentes de gripe")));
    }
}
