package clinic.event;

import clinic.basic.BasicId;
import clinic.patient.Patient;
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
@NoArgsConstructor
@AllArgsConstructor
public class Event extends BasicId {

    LocalDateTime start;
    LocalDateTime end;
    @ManyToOne
    Patient patient;
}
