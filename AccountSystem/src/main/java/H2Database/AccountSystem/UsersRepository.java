package H2Database.AccountSystem;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<User, Long> {
    public List<User> findUsersByUsername(String username);
    public List<User> findAllById(long id);
}
