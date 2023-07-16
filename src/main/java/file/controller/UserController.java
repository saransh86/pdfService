package file;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    file.UserRepository userRepository;
    @GetMapping("/users")
    public ResponseEntity<List<file.User>> getAllUsers(@RequestParam(required = false) String username){
        try{
            List<file.User> Users = new ArrayList<>();

            if(username == null){
                userRepository.findAll().forEach(Users::add);
            }
            else{
                Users.add(userRepository.findByUsername(username));
            }

            return new ResponseEntity<>(Users, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
