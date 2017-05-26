package clinic.patient;

import clinic.common.Gender;
import clinic.common.Person;
import clinic.common.address.Address;
import clinic.user.User;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Tomas
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Patient extends Person {

    public Patient(User user, String name, String email, Address address,
            LocalDate birthdate, Gender gender, String phone, String cellphone) {
        super(name, email, address, birthdate, gender, phone, cellphone);
        this.user = user;
    }

    @ManyToOne
    private User user;

}
