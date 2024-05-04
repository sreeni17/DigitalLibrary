package sreeni.digitallibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private String id;

    private String title;

    private String author;

    private Double rating;

    private Genre genre;

    private Double cost;

    private List<Review> reviewList;

    private Integer year;


    //    @Override
//    public boolean equals(Object o){
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Book book = (Book) o;
//        return Objects.equals(getId(), book.getId());
//    }

    @Override
    public int hashCode() {
        return Integer.valueOf(getId());
    }
}
