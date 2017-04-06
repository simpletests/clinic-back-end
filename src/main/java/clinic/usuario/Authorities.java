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
public class Authorities extends BasicId {
    
    private String username;
    private String authority;
}
