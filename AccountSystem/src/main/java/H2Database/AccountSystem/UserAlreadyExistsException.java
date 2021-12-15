package H2Database.AccountSystem;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserAlreadyExistsException extends ResponseStatusException {
    UserAlreadyExistsException() {
        super(HttpStatus.CONFLICT, "User with such username already exists");
    }
}
