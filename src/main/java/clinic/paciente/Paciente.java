package clinic.paciente;

import clinic.common.Sexo;
import clinic.common.Endereco;
import clinic.basic.BasicId;
import javax.persistence.Entity;
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

    private String nome;
    private String email;
    @OneToOne
    private Endereco endereco;
    private Integer idade;
    private Sexo sexo;
    private String telefoneFixo;
    private String telefoneCelular;
}