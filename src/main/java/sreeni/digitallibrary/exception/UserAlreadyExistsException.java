package sreeni.digitallibrary.exception;

public class UserAlreadyExistsException extends RuntimeException{


  public UserAlreadyExistsException(String message) {
    super(message);
  }
}