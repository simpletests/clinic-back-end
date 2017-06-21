package clinic.user;

import clinic.common.Person;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Tomas
 */
@Entity
@Table(name = "user_")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User extends Person {

    private String name;
    private String username;
    private String password;
    private boolean enabled;
    @Enumerated
    private Role role;
}
