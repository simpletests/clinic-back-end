package clinic.common;

import clinic.user.Role;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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

    @GetMapping("/gender")
    public List<Gender> opcoesSexo() {
        return Stream.of(Gender.values()).collect(Collectors.toList());
    }
    
    @GetMapping("/roles")
    public List<Role> opcoesRoles() {
        return Stream.of(Role.values()).collect(Collectors.toList());
    }
}
