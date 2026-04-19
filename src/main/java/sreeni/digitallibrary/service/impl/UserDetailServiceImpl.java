package sreeni.digitallibrary.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sreeni.digitallibrary.domain.User;
import sreeni.digitallibrary.exception.UserAlreadyExistsException;
import sreeni.digitallibrary.repository.UserRepository;
import sreeni.digitallibrary.service.UserService;

@Service
public class UserDetailServiceImpl implements UserService {

  @Autowired
  UserRepository userRepository;

  @Autowired
  PasswordEncoder passwordEncoder;

  public void setUserRepository(UserRepository userRepository) {
    this.userRepository=userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> optionalUser=userRepository.findByUsername(username);
    if(optionalUser.isPresent()){
      return optionalUser.get();
    }
    else{
      throw  new UsernameNotFoundException("User not found");
    }

    //return optionalUser.orElseThrow(()->new UsernameNotFoundException("User not found"));
  }

  @Override
  public void addUser(User user) {
    Optional<User> optionalUser=userRepository.findByUsername(user.getUsername());
    if(optionalUser.isEmpty()){
      user.setAuthority("USER");
      user.setPassword(passwordEncoder.encode(user.getPassword()));
      userRepository.save(user);
    }else {
      throw new UserAlreadyExistsException("User already exists");
    }
  }
}
