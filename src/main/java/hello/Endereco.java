package hello;

import javax.persistence.Entity;

/**
 *
 * @author tomaslm
 */
@Entity
public class Endereco extends BasicId {

    String pais;
    String cidade;
    String logradouro;
    Integer numero;
    String complemento;
}
