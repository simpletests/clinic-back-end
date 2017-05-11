package clinic.user;

import clinic.basic.BasicId;
import java.util.List;
import javax.persistence.ElementCollection;
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
public class User extends BasicId {

    private String username;
    private String password;
    private boolean enable;
    @Enumerated
    @ElementCollection
    private List<Role> roles;
}
