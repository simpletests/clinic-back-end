package clinic.user;

import clinic.basic.BasicId;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Tomas
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BasicId {

    String login;
    String password;
}
