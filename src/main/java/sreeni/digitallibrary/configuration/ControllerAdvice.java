package sreeni.digitallibrary.configuration;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

  @ExceptionHandler(NullPointerException.class)
  public ResponseEntity<?> handleNullPointerException(NullPointerException e) {
    return new ResponseEntity<>("something went wrong", HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
    Map<String, String> errorsMap = new HashMap<>();
    for(FieldError error:e.getBindingResult().getFieldErrors()) {
      errorsMap.put(error.getField(), error.getDefaultMessage());
    }
    return new ResponseEntity<>(errorsMap, HttpStatus.BAD_REQUEST);
  }
}
