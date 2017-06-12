package clinic.user;

import clinic.common.Person;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
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
public class User extends Person {

    private String name;
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private boolean enabled;
    @Enumerated
    private Role role;
}
