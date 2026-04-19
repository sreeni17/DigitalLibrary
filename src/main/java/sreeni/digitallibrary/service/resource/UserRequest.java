package sreeni.digitallibrary.service.resource;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sreeni.digitallibrary.domain.User;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
  @NotBlank
  private String username;
  @NotBlank
  private String password;
  @Email
  private String email;
  @NotBlank
  @Pattern(regexp = "^(\\+91[\\-\\s]?)?[0]?(91)?[6789]\\d{9}$",message = "Invalid phone number")
  private String phoneNumber;

  public User toUser() {
    return User.builder()
        .username(username)
        .password(password)
        .email(email)
        .phoneNumber(phoneNumber)
        .build();
  }

}
