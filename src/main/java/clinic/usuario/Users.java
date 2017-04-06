package clinic.usuario;

import clinic.basic.BasicId;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author wesley
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Users extends BasicId {
    private String username;
    private String password;
    private boolean enabled;
}
