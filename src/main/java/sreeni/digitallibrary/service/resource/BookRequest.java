package sreeni.digitallibrary.service.resource;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import sreeni.digitallibrary.domain.Genre;

@Getter
@Setter
public class BookRequest {
  @NotBlank(message = "title cannot be blank")
  private String title;
  @NotBlank(message = "author cannot be blank")
  private String author;
  private Genre genre;
  @Min(value = 0, message = "cost cannot be less than zero")
  private Double cost;
  @Min(value = 1000, message = "year cannot be less than 1000")
  private Integer year;
}
