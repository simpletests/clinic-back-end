package clinic.common;

import clinic.basic.BasicId;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 * @author tomaslm
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Endereco extends BasicId {

    String logradouro;
    Integer numero;
    String complemento;
    String cidade;
    String pais;
    String estado;

    public String getLabel() {
        StringBuilder sb = new StringBuilder();
        sb.append(logradouro)
                .append(", ")
                .append(numero)
                .append(", ")
                .append(complemento)
                .append(", ")
                .append(estado)
                .append(", ")
                .append(cidade)
                .append(", ")
                .append(pais);
        return sb.toString();
    }

}
