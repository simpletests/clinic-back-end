package clinic.paciente;

import clinic.basic.BasicId;
import clinic.common.Endereco;
import clinic.common.Sexo;
import clinic.usuario.Usuario;
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
public class Paciente extends BasicId {

    @ManyToOne
    private Usuario usuario;

    private String nome;

    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    private Integer idade;

    private Sexo sexo;

    private String telefoneFixo;

    private String telefoneCelular;
}
