package clinic.patient;

import clinic.basic.BasicId;
import clinic.common.Address;
import clinic.common.Gender;
import clinic.user.User;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
public class Patient extends BasicId {

    @ManyToOne
    private User usuario;

    private String nome;

    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Address endereco;

    private Integer idade;

    private Gender sexo;

    private String telefoneFixo;

    private String telefoneCelular;
}
