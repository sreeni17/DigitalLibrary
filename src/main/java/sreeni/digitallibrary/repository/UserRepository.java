package sreeni.digitallibrary.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import sreeni.digitallibrary.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);
}
