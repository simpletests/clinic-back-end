package clinic.usuario;

import clinic.basic.BasicId;
import java.util.Set;
import javax.persistence.Entity;
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
public class Role extends BasicId {
    
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<User> usuarios;
}
