package H2Database.AccountSystem;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserNotFoundException extends ResponseStatusException {
    UserNotFoundException() {
        super(HttpStatus.NOT_FOUND, "No users with such id");
    }
}
