package clinic.common;

import clinic.basic.BasicId;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 *
 * @author tomaslm
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Endereco extends BasicId {

    String pais;
    String cidade;
    String logradouro;
    Integer numero;
    String complemento;
}
