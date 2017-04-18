package clinic.common;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tomaslm
 */
@CrossOrigin
@RestController
@RequestMapping("/optionsSelect")
public class OptionsSelectController {

    @PreAuthorize("hasRole('MEDICO')")
    @GetMapping("/gender")
    public List<Gender> opcoesSexo() {
        return Stream.of(Gender.values()).collect(Collectors.toList());
    }
}
