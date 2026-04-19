package sreeni.digitallibrary.configuration;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class AppAuthenticationProvider implements AuthenticationProvider {

  @Autowired
  UserDetailsService userDetailsService;

  @Autowired
  PasswordEncoder encoder;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String username=authentication.getName();
    UserDetails userDetails= userDetailsService.loadUserByUsername(username);
    if(Objects.nonNull(userDetails)){
      if(encoder.matches(authentication.getCredentials().toString(),userDetails.getPassword())){
        return new UsernamePasswordAuthenticationToken(userDetails.getUsername(),userDetails.getPassword(),userDetails.getAuthorities());
      }
    }
    throw new BadCredentialsException("Invalid username or password");
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);

        /*if(UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication))
            return true;
        if(JaasAuthenticationProvider.class.isAssignableFrom(authentication))
            return true;
        else
            return false;*/
  }
}
