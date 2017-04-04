package clinic.common;

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
@RequestMapping("/opcoesSelect")
public class OpcoesSelectController {

    @GetMapping("/sexo")
    public List<Sexo> opcoesSexo() {
        return Stream.of(Sexo.values()).collect(Collectors.toList());
    }
}
