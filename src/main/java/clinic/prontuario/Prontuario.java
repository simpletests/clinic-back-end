package clinic.prontuario;

import clinic.basic.BasicId;
import clinic.paciente.Paciente;
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
public class Prontuario extends BasicId {

    @ManyToOne
    Paciente paciente;

    LocalDateTime data;

    String observacoes;
}
