package clinic.common;

import clinic.basic.BasicId;
import clinic.common.address.Address;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import javax.persistence.CascadeType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Tomas
 */
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person extends BasicId {

    private String name;

    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address = new Address();

    private LocalDate birthdate = LocalDate.of(1970, Month.JANUARY, 1);

    private Gender gender = Gender.MALE;

    private String phone;

    private String cellphone;

    public long getAge() {
        return getBirthdate().until(LocalDate.now(), ChronoUnit.YEARS);
    }
}
