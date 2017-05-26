package clinic.common.address;

import clinic.basic.BasicId;
import java.util.Optional;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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
    @ManyToOne(optional = false)
    PostalCode postalCode;

    public String getLabel() {
        StringBuilder sb = new StringBuilder();
        sb.append(street)
                .append(", ")
                .append(number)
                .append(", ")
                .append(complement)
                .append(", ")
                .append(Optional.ofNullable(getPostalCode()).map(PostalCode::getLabel).orElse(""));
        return sb.toString();
    }

}
