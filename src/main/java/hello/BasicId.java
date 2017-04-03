package hello;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author tomaslm
 */
@MappedSuperclass
@Getter
@Setter
public class BasicId {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
}
