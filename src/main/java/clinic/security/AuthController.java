/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinic.security;

import clinic.user.User;
import clinic.user.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wesley
 */
@CrossOrigin
@RestController
@RequestMapping("/oauth")
public class AuthController {
    
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public ResponseEntity<User> findByUsernamePassword(@RequestParam String username, @RequestParam String password) {
        Optional<User> opUser = userRepository.findByUsernameAndPassword(username, password);
        if (opUser.isPresent()) {
            return new ResponseEntity<>(opUser.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
