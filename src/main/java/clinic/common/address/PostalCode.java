package clinic.common.address;

import clinic.basic.BasicId;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 * @author Tomas
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostalCode extends BasicId {

    Long postalCode;
    String country;
    String state;
    String city;

    public String getLabel() {
        return new StringBuilder()
                .append(city)
                .append(", ")
                .append(state)
                .append(", ")
                .append(country).toString();
    }

}
