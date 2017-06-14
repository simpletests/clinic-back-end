package clinic.handbook;

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
@AllArgsConstructor
@NoArgsConstructor
public class Handbook extends BasicId {

    @ManyToOne
    Patient patient;

//    @ManyToOne
//    User doctor;
    LocalDateTime dateTime;

    String queixaPrincipal;

    String historiaDoencaAtual;

    String antecedentesFisiologicosPatologicos;

    String historiaPatologica;

    String habitosDeVida;

    String observations;

    String resumo;
}
