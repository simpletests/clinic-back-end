package clinic.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author tomaslm
 */
@Getter
@AllArgsConstructor
public enum Gender {
    MASCULINO("Masculino"), FEMININO("Feminino");

    String mensagem;

    public Integer getValue() {
        return ordinal();
    }
}
