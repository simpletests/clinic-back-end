package clinic.user;

import clinic.basic.BasicId;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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

    private String name;
    private String username;
    private String password;
    private boolean enabled;
    @Enumerated
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Role> roles;
}
