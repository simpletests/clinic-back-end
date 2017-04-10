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
public class Address extends BasicId {

    String street;
    Integer number;
    String complement;
    String city;
    String country;
    String state;

    public String getLabel() {
        StringBuilder sb = new StringBuilder();
        sb.append(street)
                .append(", ")
                .append(number)
                .append(", ")
                .append(complement)
                .append(", ")
                .append(state)
                .append(", ")
                .append(city)
                .append(", ")
                .append(country);
        return sb.toString();
    }

}
