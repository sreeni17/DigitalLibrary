package sreeni.digitallibrary.service.resource;

import lombok.*;

import java.util.List;
import sreeni.digitallibrary.domain.Review;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookResponse {

  private String title;
  private String author;

  private Double rating;
  private Double cost;
  List<Review> reviewList;


  public BookResponse(String title, String author, Double rating, Double cost) {
    this.title = title;
    this.author = author;
    this.rating = rating;
    this.cost = cost;
  }
}
