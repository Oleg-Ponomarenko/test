package H2Database.AccountSystem;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accountsystem")
public class Controller {
    private final UsersRepository usersRepository;

    Controller(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @PostMapping("/users")
    public User createAccount(@RequestBody User user) {
        if (!usersRepository.findUsersByUsername(user.getUsername()).isEmpty()) {
            throw new UserAlreadyExistsException();
        }

        return usersRepository.save(new User(user.getUsername(), user.getPassword(), user.getAge()));
    }

    @GetMapping("/users/{id}")
    public List<User> findById(@PathVariable("id") long id) {
        if (usersRepository.findAllById(id).isEmpty()) {
            throw new UserNotFoundException();
        }

        return usersRepository.findAllById(id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable("id") long id) {
        if (usersRepository.findAllById(id).isEmpty()) {
            throw new UserNotFoundException();
        }
        else {
            usersRepository.deleteById(id);
        }
    }

    @PutMapping("/users/{id}")
    public User updateById(@PathVariable("id") long id, @RequestBody User user) {
        if (usersRepository.findAllById(id).isEmpty()) {
            throw new UserNotFoundException();
        }
        else {
            Optional<User> userData = usersRepository.findById(id);
            User newUser = userData.get();
            newUser.setUsername(user.getUsername());
            newUser.setPassword(user.getPassword());
            newUser.setAge(user.getAge());
            return usersRepository.save(newUser);
        }
    }
}
