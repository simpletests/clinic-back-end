package clinic.usuario;

import clinic.basic.BasicId;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
public class User extends BasicId {
    
    private String username;
    private String password;
    @ManyToMany 
    @JoinTable(name = "user_role", 
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
