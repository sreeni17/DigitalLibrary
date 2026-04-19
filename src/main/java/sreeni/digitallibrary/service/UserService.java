package sreeni.digitallibrary.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import sreeni.digitallibrary.domain.User;

public interface UserService extends UserDetailsService {
  public void addUser(User user);
}
