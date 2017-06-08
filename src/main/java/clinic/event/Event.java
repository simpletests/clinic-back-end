package clinic.event;

import clinic.basic.BasicId;
import clinic.handbook.Handbook;
import clinic.patient.Patient;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    LocalDateTime start = LocalDateTime.now();
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    LocalDateTime end;
    @ManyToOne
    Patient patient;
    @OneToOne(cascade = CascadeType.ALL)
    Handbook handbook;
}
