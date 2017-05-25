package clinic.handbook;

import clinic.basic.BasicId;
import clinic.patient.Patient;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author tomaslm
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Handbook extends BasicId {

    @ManyToOne
    Patient patient;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    LocalDateTime dateTime;

    String observations;

    public String getResume() {
        StringBuilder sb = new StringBuilder();
        sb.append("Patient was with a suspect of ");
        sb.append(", with the follow observations ").append(getObservations());
        return sb.toString();
    }
}
