/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package clinic;

import clinic.common.Address;
import clinic.common.Gender;
import clinic.event.Event;
import clinic.event.EventRepository;
import clinic.patient.Patient;
import clinic.patient.PatientRepository;
import clinic.user.Role;
import clinic.user.User;
import clinic.user.UserRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PatientRepository patientRepository;

    @Before
    public void fillData() {
        User medico1 = new User("Dr. Carlos da Silva Santos", "123", true, Arrays.asList(Role.MEDICO));
        userRepository.save(medico1);
        Patient sabrina = new Patient(medico1, "Sabrina", "tomaslm@hotmail.com",
                new Address("Rua São José", 100, "casa", "São Paulo", "Ribeirão Preto", "Brasil"),
                22, Gender.FEMININO, "3202-3063", "99332-1131");
        patientRepository.save(sabrina);
        eventRepository.save(new Event(LocalDateTime.of(LocalDate.now(), LocalTime.of(14, 0)),
                LocalDateTime.of(LocalDate.now(), LocalTime.of(14, 50)), sabrina));
        eventRepository.save(new Event(LocalDateTime.of(LocalDate.now().plusDays(3), LocalTime.of(14, 0)),
                LocalDateTime.of(LocalDate.now().plusDays(3), LocalTime.of(14, 50)), sabrina));
    }

    @Test
    public void test() {
        User usr = userRepository.findOne(1L);
        LocalDateTime start = LocalDateTime.of(2017, 1, 1, 0, 0);
        LocalDateTime end = LocalDateTime.of(2017, 6, 1, 0, 0);
        List<Event> events = eventRepository
                .findByPatientUserAndStartBetween(usr, start, end);
        System.out.println("events size:" + events.size());
//        assert (events.size() == 2);
    }

}
