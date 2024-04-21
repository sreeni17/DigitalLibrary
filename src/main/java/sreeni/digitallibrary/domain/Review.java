package sreeni.digitallibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    private String id;

    private String comment;

    private String reviewer;

    private Double rating;

    private String bookId;
}
