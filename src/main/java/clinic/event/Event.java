package clinic.event;

import clinic.basic.BasicId;
import clinic.handbook.Handbook;
import clinic.patient.Patient;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
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
@JsonInclude(Include.ALWAYS)
public class Event extends BasicId {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    LocalDateTime start;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    LocalDateTime end;
    @ManyToOne
    Patient patient;
    @OneToOne(cascade = CascadeType.ALL)
    Handbook handbook;
}
