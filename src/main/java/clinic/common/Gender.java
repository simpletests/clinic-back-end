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
    MALE("Masculino"), FEMALE("Feminino");

    String mensagem;

    public Integer getValue() {
        return ordinal();
    }
}
